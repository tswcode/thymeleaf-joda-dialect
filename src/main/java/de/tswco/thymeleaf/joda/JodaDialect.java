/**
 * 
 */
package de.tswco.thymeleaf.joda;

import java.util.HashMap;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.IContext;
import org.thymeleaf.context.IProcessingContext;
import org.thymeleaf.context.IWebContext;
import org.thymeleaf.dialect.AbstractDialect;
import org.thymeleaf.dialect.IExpressionEnhancingDialect;

import de.tswco.thymeleaf.joda.objects.Joda;

/**
 * @author watzke
 *
 */
@Service
public class JodaDialect extends AbstractDialect implements
		IExpressionEnhancingDialect {
	
	public static final String DEFAULT_PREFIX = "joda";
	public static final String JODA_EXPRESSION_OBJECT_NAME = "joda";
	
	@Autowired
	private Joda joda;
	
	public JodaDialect() {
		super();
	}
			
	/* (non-Javadoc)
	 * @see org.thymeleaf.dialect.IDialect#getPrefix()
	 */
	@Override
	public String getPrefix() {
		return DEFAULT_PREFIX;
	}

	/* (non-Javadoc)
	 * @see org.thymeleaf.dialect.IDialect#isLenient()
	 */
	@Override
	public boolean isLenient() {
		return false;
	}

	/* (non-Javadoc)
	 * @see org.thymeleaf.dialect.IExpressionEnhancingDialect#getAdditionalExpressionObjects(org.thymeleaf.context.IProcessingContext)
	 */
	@Override
	public Map<String, Object> getAdditionalExpressionObjects(
			IProcessingContext processingContext) {

		final IContext context = processingContext.getContext();
		final IWebContext webContext = 
				(context instanceof IWebContext ? (IWebContext) context : null);
		
		final Map<String, Object> objects = new HashMap<>(1, 1.0f);
		
		/*
		 * create the #joda expression objects
		 */
		if(webContext != null) {
			objects.put(JODA_EXPRESSION_OBJECT_NAME, joda);
			
			/*
			final HttpServletRequest servletRequest = webContext.getHttpServletRequest();
            final HttpServletResponse servletResponse = webContext.getHttpServletResponse();
            final ServletContext servletContext = webContext.getServletContext();
			
			if(servletRequest != null) {
				//final Joda jodaObj = new Joda(servletRequest);
				
				
			}
			*/
		}
		
		return objects;
	}

}
