/**
 * (c) 2003-2015 MuleSoft, Inc. The software in this package is published under the terms of the CPAL v1.0 license,
 * a copy of which has been included with this distribution in the LICENSE.md file.
 */



package org.mule.modules.googletranslatejersey;

import java.util.List;

import org.mule.api.annotations.Config;
import org.mule.api.annotations.Connector;
import org.mule.api.annotations.Processor;
import org.mule.api.annotations.display.FriendlyName;
import org.mule.api.annotations.lifecycle.Start;
import org.mule.modules.googletranslatejersey.client.GoogleTranslateClient;
import org.mule.modules.googletranslatejersey.config.ConnectorConfig;
import org.mule.modules.googletranslatejersey.entities.Detection;
import org.mule.modules.googletranslatejersey.entities.Language;
import org.mule.modules.googletranslatejersey.entities.Translation;
import org.mule.modules.googletranslatejersey.exception.GoogleTransalteConnectorException;

/**
 * Google Translate Connector
 *
 * @author Nathan (Dae Hyun) Nam
 */
@Connector(name="google-translate-jersey", friendlyName="Google Translate")
public class GoogleTranslateJerseyConnector {

    @Config
    ConnectorConfig config;  

    private GoogleTranslateClient client;
    
    @Start
    public void init(){
    	setClient(new GoogleTranslateClient(this));
    }
    
    public GoogleTranslateClient getClient() {
        return client;
    }

    public void setClient(GoogleTranslateClient client) {
        this.client = client;
    }
    
    public ConnectorConfig getConfig() {
        return config;
    }

    public void setConfig(ConnectorConfig config) {
        this.config = config;
    }
    
	public String getApiUrl(){
		return this.config.getApiUrl();
	}

	public String getApiVersion(){
		return this.config.getApiVersion();
	}

	public String getApiKey(){
		return this.config.getApiKey();
	}
	
	public void setApiKey(String apiKey){
		this.config.setApiKey(apiKey);
	}
    
	
	/**
     * Get a translated text based on a target language (less than 2K characters).
     * <p/>
     * {@sample.xml ../../../doc/google-translate-jersey-connector.xml.sample google-translate-jersey:get-translate}
     * @param source the language of the source text
     * @param target the language to translate the source text into
     * @param text the text to be translated (less than 2K characters)
	 * @return a list of the translated text
	 * @throws GoogleTransalteConnectorException If the response is an error or the response cannot be parsed as a Translation. 
	 */
    @Processor(friendlyName = "Tranlate Text")
    public List<Translation> getTranslate(@FriendlyName("Source Languange") String source,
    		@FriendlyName("Target Languange") String target,
    		@FriendlyName("Text") String text) throws GoogleTransalteConnectorException {
        return getClient().getTranslate(source,target,text);
    }
    
    /**
     * Get a translated text based on a target language (less than 5K characters). X-HTTP-Method-Override header should be set as "GET" to tell the translate api to treat the request as a GET.
     * <p/>
     * {@sample.xml ../../../doc/google-translate-jersey-connector.xml.sample google-translate-jersey:post-translate}
     * @param source the language of the source text
     * @param target the language to translate the source text into
     * @param text the text to be translated (less than 5K characters)
     * @return a list of the translated text
     * @throws GoogleTransalteConnectorException If the response is an error or the response cannot be parsed as a Translation.
     */
    @Processor(friendlyName = "Tranlate Longer Text")
    public List<Translation> postTranslate(@FriendlyName("Source Languange") String source,
    		@FriendlyName("Target Languange") String target,
    		@FriendlyName("Text") String text) throws GoogleTransalteConnectorException {
        return getClient().postTranslate(source,target,text);
    }
    
    /**
	 * Get a list of supported languages by Google Translate.
     * <p/>
     * {@sample.xml ../../../doc/google-translate-jersey-connector.xml.sample google-translate-jersey:get-supported-languages}
     * @param target language code will be paired with a full name in a language specified in Target Language.
     * @return a list of the supported languages by Google Translate
     * @throws GoogleTransalteConnectorException If the response is an error or the response cannot be parsed as a Language.
     */
    @Processor(friendlyName = "Supported Languages")
    public List<Language> getSupportedLanguages(@FriendlyName("Target Languange") String target)
    		throws GoogleTransalteConnectorException {
        return getClient().getSupportedLanguages(target);
    }
    
    /**
     * Detect in which language a text is written (less than 2K characters).
     * <p/>
     * {@sample.xml ../../../doc/google-translate-jersey-connector.xml.sample google-translate-jersey:get-detect-language}
     * @param text the text to be detected (less than 2K characters)
     * @return a list of information including the detected language
     * @throws GoogleTransalteConnectorException If the response is an error or the response cannot be parsed as a Detection.
     */
    @Processor(friendlyName = "Detect Language")
    public List<Detection> getDetectLanguage(@FriendlyName("Text") String text) 
    		throws GoogleTransalteConnectorException {
        return getClient().getDetectLanguage(text);
    }
    
    /**
     * Detect in which language a text is written (less than 5K characters).
     * <p/>
     * {@sample.xml ../../../doc/google-translate-jersey-connector.xml.sample google-translate-jersey:post-detect-language}
     * @param text the text to be detected (less than 5K characters)
     * @return a list of information including the detected language
     * @throws GoogleTransalteConnectorException If the response is an error or the response cannot be parsed as a Detection.
     */
    @Processor(friendlyName = "Detect Language From Longer Text")
    public List<Detection> postDetectLanguage(@FriendlyName("Text") String text) 
    		throws GoogleTransalteConnectorException {
        return getClient().postDetectLanguage(text);
    }

}