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
import org.mule.modules.googletranslatejersey.entities.Detection;
import org.mule.modules.googletranslatejersey.exception.GoogleTransalteConnectorException;

public class GetDetectLanguageTestCases extends GoogleTranslateJerseyConnectorAbstractTestCases{
	@Test
    public void testGetDetectLanguage() throws IOException, GoogleTransalteConnectorException {
	  List<Detection> detectedLaguage= getConnector().getDetectLanguage(TEST_MESSAGE);
	  Detection firsLanguage = detectedLaguage.get(0);  
	  assertEquals(true, firsLanguage.getLanguage().startsWith("en"));
	  
	}
}
