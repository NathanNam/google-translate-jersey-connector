package org.mule.modules.googletranslatejersey.automation.functional;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.List;

import org.junit.Test;
import org.mule.modules.googletranslatejersey.automation.runner.AbstractGoogleTranslateJerseyTestCases;
import org.mule.modules.googletranslatejersey.entities.Detection;
import org.mule.modules.googletranslatejersey.exception.GoogleTransalteConnectorException;

public class PostDetectLanguageTestCases extends AbstractGoogleTranslateJerseyTestCases{

	@Test
    public void testPostDetectLanguage() throws IOException, GoogleTransalteConnectorException {	
	  List<Detection> detectedLaguage= getConnector().postDetectLanguage(TEST_MESSAGE);
	  Detection firsLanguage = detectedLaguage.get(0);  
	  assertEquals(true, firsLanguage.getLanguage().startsWith("en"));
	  
	}
}
