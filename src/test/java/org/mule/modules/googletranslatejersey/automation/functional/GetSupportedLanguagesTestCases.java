package org.mule.modules.googletranslatejersey.automation.functional;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.List;

import org.junit.Test;
import org.mule.modules.googletranslatejersey.automation.runner.AbstractGoogleTranslateJerseyTestCases;
import org.mule.modules.googletranslatejersey.entities.Language;
import org.mule.modules.googletranslatejersey.exception.GoogleTransalteConnectorException;

public class GetSupportedLanguagesTestCases extends AbstractGoogleTranslateJerseyTestCases  {

	@Test
    public void testGetSupportedLanguages() throws IOException, GoogleTransalteConnectorException {
	  List<Language> laguageList= getConnector().getSupportedLanguages(API_KEY, TARGET_LANGUAGE);
	  Language firsLanguage = laguageList.get(0);  
	  assertEquals(true, firsLanguage.getLanguage().startsWith("af"));
	  
	}
}
