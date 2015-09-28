package org.mule.modules.googletranslatejersey.automation.functional;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.List;

import org.junit.Test;
import org.mule.modules.googletranslatejersey.automation.runner.AbstractGoogleTranslateJerseyTestCases;
import org.mule.modules.googletranslatejersey.entities.Translation;
import org.mule.modules.googletranslatejersey.exception.GoogleTransalteConnectorException;

public class GetTranslateTestCases extends AbstractGoogleTranslateJerseyTestCases  {

	@Test
    public void testGetTranslate() throws IOException, GoogleTransalteConnectorException {
	  List<Translation> translatedTextList= getConnector().getTranslate(API_KEY, SOURCE_LANGUAGE, TARGET_LANGUAGE, TEST_MESSAGE);
	  Translation translatedText = translatedTextList.get(0);  
	  assertEquals(true, translatedText.getTranslatedText().startsWith("Guten Morgen, Nathan!"));
	  
	}
	
}