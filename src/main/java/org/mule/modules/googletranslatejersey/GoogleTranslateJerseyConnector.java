package org.mule.modules.googletranslatejersey;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
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

@Connector(name="google-translate-jersey", friendlyName="GoogleTranslateJersey")
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
    
	
    /**
     * Get a translated text based on a target language
     * @param source: the language of the source text
     * @param target: the language to translate the source text into
     * @param text: the text to be translated (less than 2K characters)
     * @return
     * @throws IOException 
     * @throws JsonMappingException 
     * @throws JsonParseException 
     */
    @Processor(friendlyName = "Tranlate Text")
    public List<Translation> getTranslate(@FriendlyName("API Key") String apiKey, @FriendlyName("Source Languange") String source,
    		@FriendlyName("Target Languange") String target,
    		@FriendlyName("Text") String text) throws GoogleTransalteConnectorException {
        return getClient().getTranslate(apiKey, source,target,text);
    }
	

	/**
     * Get a translated text based on a target language (for a longer text)
     * X-HTTP-Method-Override header should be set as "GET" to tell the translate api to treat the request as a GET.
     * @param source: the language of the source text
     * @param target: the language to translate the source text into
     * @param text: the text to be translated (less than 5K characters)
     * @return
     */
    @Processor(friendlyName = "Tranlate Longer Text")
    public List<Translation> postTranslate(@FriendlyName("API Key") String apiKey, @FriendlyName("Source Languange") String source,
    		@FriendlyName("Target Languange") String target,
    		@FriendlyName("Text") String text) throws GoogleTransalteConnectorException {
        return getClient().postTranslate(apiKey, source,target,text);
    }
	
	/**
	 * * Get a list of supported languages by Google Translate.
     * @param target: language code will be paired with a full name in a language specified in targetLanguage.
	 * @return
	 */
    @Processor(friendlyName = "Supported Languages")
    public List<Language> getSupportedLanguages(@FriendlyName("API Key") String apiKey, @FriendlyName("Target Languange") String target)
    		throws GoogleTransalteConnectorException {
        return getClient().getSupportedLanguages(apiKey,target);
    }

    
    /**
     * Detect in which language a text is written.
     * @param text: the text to be detected (less than 2K characters)
     * @return
     */
    @Processor(friendlyName = "Detect Language")
    public List<Detection> getDetectLanguage(@FriendlyName("API Key") String apiKey, @FriendlyName("Text") String text) 
    		throws GoogleTransalteConnectorException {
        return getClient().getDetectLanguage(apiKey, text);
    }
    
    /**
     * Detect in which language a text is written.
     * @param text: the text to be detected (less than 5K characters)
     * @return
     */
    @Processor(friendlyName = "Detect Language From Longer Text")
    public List<Detection> postDetectLanguage(@FriendlyName("API Key") String apiKey, @FriendlyName("Text") String text) 
    		throws GoogleTransalteConnectorException {
        return getClient().postDetectLanguage(apiKey, text);
    }

}