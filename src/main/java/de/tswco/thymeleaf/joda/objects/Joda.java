/**
 * 
 */
package de.tswco.thymeleaf.joda.objects;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.LocaleResolver;


/**
 * @author watzke
 *
 */
@Service
public final class Joda {
	
	private final static String DEFAULT_STYLE = "MS";
	
	@Autowired
	private LocaleResolver localeResolver;
	
	@Autowired
	private HttpServletRequest servletRequest;
	
	public Joda() {
		super();
	}

	public String format(final DateTime dateTime) {
		return format(dateTime, DEFAULT_STYLE);
	}
	
	public String format(final DateTime dateTime, String style) {
		String dateTimeString = ""; 
		if(dateTime != null) {
			dateTimeString = DateTimeFormat.forStyle(style).withLocale(getLocale()).print(dateTime);
		}		
		return dateTimeString;
	}
	
	private Locale getLocale() {
		return localeResolver.resolveLocale(servletRequest);
	}
	
}
