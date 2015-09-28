package org.mule.modules.googletranslatejersey.automation.runner;

import org.mule.modules.googletranslatejersey.GoogleTranslateJerseyConnector;
import org.mule.tools.devkit.ctf.junit.AbstractTestCase;

public class AbstractGoogleTranslateJerseyTestCases extends AbstractTestCase<GoogleTranslateJerseyConnector> {

	 public static final String API_KEY = "AIzaSyDtnLEX62fN8opjNb6Vf_t70Dure0F_zbU"; 
	 public static final String SOURCE_LANGUAGE = "en";
	 public static final String TARGET_LANGUAGE = "de";
	 public static final String TEST_MESSAGE = "Good morning, Nathan!";
	
	 public AbstractGoogleTranslateJerseyTestCases() {
	        super(GoogleTranslateJerseyConnector.class);
	    }
	 
}