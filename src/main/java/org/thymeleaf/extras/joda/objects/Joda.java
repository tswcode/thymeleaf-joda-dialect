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
package org.thymeleaf.extras.joda.objects;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.LocaleResolver;

/**
 * @author watzke, dhubau
 * 
 */
@Service
public class Joda {

	private final static String DEFAULT_STYLE = "MS";

	@Autowired
	private LocaleResolver localeResolver;

	@Autowired
	private HttpServletRequest servletRequest;

	/**
	 * Prints out a formatted {@link DateTime} instance with the default style.
	 * The default style is 'MS' meaning a medium Date and small Time formatting.
	 * For more information, check the {@link DateTimeFormat#forStyle(String)} documentation. 
	 * @param dateTime
	 * @return a formatted {@link DateTime} string
	 */
	public String format(final DateTime dateTime) {
		return format(dateTime, DEFAULT_STYLE);
	}

	/**
	 * Prints out a formatted {@link DateTime} instance with a given style.
	 * @param dateTime {@link DateTime} instance
	 * @param style a style used by the {@link DateTimeFormat#forStyle(String)} method
	 * @return a formatted {@link DateTime} string
	 */
	public String format(final DateTime dateTime, String style) {
		String dateTimeString = "";
		if (dateTime != null) {
			dateTimeString = DateTimeFormat.forStyle(style).withLocale(getLocale()).print(dateTime);
		}
		return dateTimeString;
	}

	private Locale getLocale() {
		return localeResolver.resolveLocale(servletRequest);
	}

}
