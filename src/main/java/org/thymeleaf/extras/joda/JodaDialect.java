/**
 * DO WHAT THE FUCK YOU WANT TO PUBLIC LICENSE
 * Version 2, December 2004
 * 
 * Copyright (C) 2004 Sam Hocevar <sam@hocevar.net>
 * 
 * Everyone is permitted to copy and distribute verbatim or modified
 * copies of this license document, and changing it is allowed as long
 * as the name is changed.
 * 
 * DO WHAT THE FUCK YOU WANT TO PUBLIC LICENSE
 * TERMS AND CONDITIONS FOR COPYING, DISTRIBUTION AND MODIFICATION
 * 
 * 0. You just DO WHAT THE FUCK YOU WANT TO.
 * 
 */
package org.thymeleaf.extras.joda;

import java.util.HashMap;
import java.util.Map;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.IContext;
import org.thymeleaf.context.IProcessingContext;
import org.thymeleaf.context.IWebContext;
import org.thymeleaf.dialect.AbstractDialect;
import org.thymeleaf.dialect.IExpressionEnhancingDialect;
import org.thymeleaf.extras.joda.objects.Joda;


/**
 * A Thymeleaf dialect that exposes the {@link Joda} service instance.
 * This service can be used to format {@link DateTime} objects in your Thymeleaf pages.
 * 
 * @author watzke, dhubau
 */
@Service
public class JodaDialect extends AbstractDialect implements IExpressionEnhancingDialect {

	public static final String DEFAULT_PREFIX = "joda";
	public static final String JODA_EXPRESSION_OBJECT_NAME = "joda";

	@Autowired
	private Joda joda;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.thymeleaf.dialect.IDialect#getPrefix()
	 */
	@Override
	public String getPrefix() {
		return DEFAULT_PREFIX;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.thymeleaf.dialect.IDialect#isLenient()
	 */
	@Override
	public boolean isLenient() {
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.thymeleaf.dialect.IExpressionEnhancingDialect#
	 * getAdditionalExpressionObjects(org.thymeleaf.context.IProcessingContext)
	 */
	@Override
	public Map<String, Object> getAdditionalExpressionObjects(IProcessingContext processingContext) {

		final IContext context = processingContext.getContext();
		final IWebContext webContext = (context instanceof IWebContext ? (IWebContext) context : null);

		final Map<String, Object> objects = new HashMap<>(1, 1.0f);

		/*
		 * create the #joda expression objects
		 */
		if (webContext != null) {
			objects.put(JODA_EXPRESSION_OBJECT_NAME, joda);
		}

		return objects;
	}

}
