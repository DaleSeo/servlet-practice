package seo.dale.practice.servlet;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Dale Seo
 */
public class AppTest {

	private App app = new App();

	@Test
	public void testHello() {
		assertEquals("Hello, Dale", app.hello("Dale"));
	}

}