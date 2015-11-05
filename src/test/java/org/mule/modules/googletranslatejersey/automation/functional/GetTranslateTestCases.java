/**
 * (c) 2003-2015 MuleSoft, Inc. The software in this package is published under the terms of the CPAL v1.0 license,
 * a copy of which has been included with this distribution in the LICENSE.md file.
 */
package org.mule.modules.googletranslatejersey.automation.functional;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.List;

import org.junit.Test;
import org.mule.modules.googletranslatejersey.automation.runner.GoogleTranslateJerseyConnectorAbstractTestCases;
import org.mule.modules.googletranslatejersey.entities.Translation;
import org.mule.modules.googletranslatejersey.exception.GoogleTransalteConnectorException;

public class GetTranslateTestCases extends GoogleTranslateJerseyConnectorAbstractTestCases  {

	@Test
    public void testGetTranslate() throws IOException, GoogleTransalteConnectorException {
	  List<Translation> translatedTextList= getConnector().getTranslate(SOURCE_LANGUAGE, TARGET_LANGUAGE, TEST_MESSAGE);
	  Translation translatedText = translatedTextList.get(0);  
	  assertEquals(true, translatedText.getTranslatedText().startsWith("Guten Morgen, Nathan!"));
	  
	}
	
}
