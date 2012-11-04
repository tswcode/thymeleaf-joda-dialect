package de.tswco.joda.utils;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

public final class DateTimeFactory {

	public static DateTime getNowDateTime() {
		return new DateTime(DateTimeZone.forID("Europe/Berlin"));
	}
	
}
