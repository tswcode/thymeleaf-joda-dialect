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

import junit.framework.Assert;

import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thymeleaf.extras.joda.utils.DateTimeFactory;

/**
 * Tests the {@link Joda} class.
 * @author dhubau
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/test-context.xml")
public class JodaTest {

	@Autowired
	private Joda joda;

	/**
	 * Test method for {@link org.thymeleaf.extras.joda.objects.Joda#format(org.joda.time.DateTime)}.
	 */
	@Test
	public void testFormatDateTime() {
		String formattedDate = joda.format(new DateTime(0));
		Assert.assertEquals("Jan 1, 1970 1:00 AM", formattedDate);
	}

	/**
	 * Test method for {@link org.thymeleaf.extras.joda.objects.Joda#format(org.joda.time.DateTime)}.
	 */
	@Test
	public void testFormatDateTimeNow() {
		String formattedDate = joda.format(DateTimeFactory.getNowDateTime());
		Assert.assertNotNull(formattedDate);
	}

	/**
	 * Test method for {@link org.thymeleaf.extras.joda.objects.Joda#format(org.joda.time.DateTime)}.
	 */
	@Test
	public void testFormatDateTimeNull() {
		String formattedDate = joda.format(null);
		Assert.assertEquals("", formattedDate);
	}

	/**
	 * Test method for {@link org.thymeleaf.extras.joda.objects.Joda#format(org.joda.time.DateTime, java.lang.String)}.
	 */
	@Test
	public void testFormatDateTimeString() {
		String formattedDate = joda.format(new DateTime(0), "S-");
		Assert.assertEquals("1/1/70", formattedDate);
	}

	/**
	 * Test method for {@link org.thymeleaf.extras.joda.objects.Joda#format(org.joda.time.DateTime, java.lang.String)}.
	 */
	@Test
	public void testFormatDateTimeStringNull() {
		String formattedDate = joda.format(null, "");
		Assert.assertEquals("", formattedDate);
	}

}
