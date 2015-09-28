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


