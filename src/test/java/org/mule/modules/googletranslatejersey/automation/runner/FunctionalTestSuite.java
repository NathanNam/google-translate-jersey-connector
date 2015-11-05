/**
 * (c) 2003-2015 MuleSoft, Inc. The software in this package is published under the terms of the CPAL v1.0 license,
 * a copy of which has been included with this distribution in the LICENSE.md file.
 */

package org.mule.modules.googletranslatejersey.automation.runner;


import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.mule.modules.googletranslatejersey.GoogleTranslateJerseyConnector;
import org.mule.modules.googletranslatejersey.automation.functional.GetDetectLanguageTestCases;
import org.mule.modules.googletranslatejersey.automation.functional.GetSupportedLanguagesTestCases;
import org.mule.modules.googletranslatejersey.automation.functional.GetTranslateTestCases;
import org.mule.modules.googletranslatejersey.automation.functional.PostDetectLanguageTestCases;
import org.mule.modules.googletranslatejersey.automation.functional.PostTranslateTestCases;
import org.mule.tools.devkit.ctf.mockup.ConnectorTestContext;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	GetTranslateTestCases.class,
	PostTranslateTestCases.class,
	GetSupportedLanguagesTestCases.class,
	GetDetectLanguageTestCases.class,
	PostDetectLanguageTestCases.class
	})
public class FunctionalTestSuite {

    @BeforeClass
    public static void initialiseSuite() {
        ConnectorTestContext.initialize(GoogleTranslateJerseyConnector.class);
    }

    @AfterClass
    public static void shutdownSuite() throws Exception {
        ConnectorTestContext.shutDown();
    }
}


