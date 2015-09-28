package org.mule.modules.googletranslatejersey.client;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.MediaType;

import org.json.JSONArray;
import org.json.JSONObject;
import org.mule.modules.googletranslatejersey.GoogleTranslateJerseyConnector;
import org.mule.modules.googletranslatejersey.entities.Detection;
import org.mule.modules.googletranslatejersey.entities.Language;
import org.mule.modules.googletranslatejersey.entities.Translation;

import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;


public class GoogleTranslateClient {

	private Client client; /* a Jersey client instance */
	private WebResource apiResource;
	private GoogleTranslateJerseyConnector connector;
	private Gson mapper;
	
	
	public GoogleTranslateClient(GoogleTranslateJerseyConnector connector) {
		setConnector(connector);
		ClientConfig clientConfig = new DefaultClientConfig();
		clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
		this.client = Client.create(clientConfig);
		this.apiResource = this.client.resource(getConnector().getApiUrl()+"/"+getConnector().getApiVersion());
		mapper = new Gson();
	}
	
	  public List<Translation>  getTranslate(String apiKey, String source, String target, String text )  {
		    WebResource webResource = getApiResource()
		    		.queryParam("key", apiKey)
		    		.queryParam("source", source)
		    		.queryParam("target", target)
		    		.queryParam("q", text);	
		    List<Translation> translatedTexts = new ArrayList<Translation>();
		    String initialReturn = execute(webResource, "GET", String.class);
		    JSONObject translations = (JSONObject) new JSONObject(initialReturn).get("data");
		    JSONArray translatedArray = (JSONArray) new JSONObject(translations.toString()).get("translations");
		    
		    for (int index=0; index<translatedArray.length();index++){
		    	JSONObject translatedText = (JSONObject) translatedArray.get(index);
			    Translation newText = mapper.fromJson(translatedText.toString(), Translation.class);
		    	translatedTexts.add(newText);
		    }
		    return translatedTexts;

	  }
	  
	  public List<Translation> postTranslate(String apiKey, String source, String target, String text ) {
		    WebResource webResource = getApiResource()
		    		.queryParam("key", apiKey)
		    		.queryParam("source", source)
		    		.queryParam("target", target)
		    		.queryParam("q", text);	
		    List<Translation> translatedTexts = new ArrayList<Translation>();
		    String initialReturn = execute(webResource, "POST", String.class);
		    JSONObject translations = (JSONObject) new JSONObject(initialReturn).get("data");
		    JSONArray translatedArray = (JSONArray) new JSONObject(translations.toString()).get("translations");
		    
		    for (int index=0; index<translatedArray.length();index++){
		    	JSONObject translatedText = (JSONObject) translatedArray.get(index);
			    Translation newText = mapper.fromJson(translatedText.toString(), Translation.class);
		    	translatedTexts.add(newText);
		    }
	    
		    return translatedTexts;
	  }



	  public List<Language> getSupportedLanguages(String apiKey, String target ) {
		    WebResource webResource = getApiResource()
		    		.path("languages")
		    		.queryParam("key", apiKey)
		    		.queryParam("target", target);	
		    
		    
		    List<Language> supportedLanguages = new ArrayList<Language>();
		    String initialReturn = execute(webResource, "GET", String.class);
		    JSONObject languages = (JSONObject) new JSONObject(initialReturn).get("data");
		    JSONArray languageArray = (JSONArray) new JSONObject(languages.toString()).get("languages");
		    
		    for (int index=0; index<languageArray.length();index++){
		    	JSONObject language = (JSONObject) languageArray.get(index);
			    Language newLanguage = mapper.fromJson(language.toString(), Language.class);

			    supportedLanguages.add(newLanguage);
		    }
		    return supportedLanguages;
	  }  
  
	  public List<Detection> getDetectLanguage(String apiKey, String text ) {
		    WebResource webResource = getApiResource()
		    		.path("detect")
		    		.queryParam("key", apiKey)
		    		.queryParam("q", text);	
		    
		    List<Detection> detectedLanguages = new ArrayList<Detection>();
		    String initialReturn = execute(webResource, "GET", String.class);
		    JSONObject detections = (JSONObject) new JSONObject(initialReturn).get("data");
		    JSONArray detectionArray = (JSONArray) new JSONObject(detections.toString()).get("detections");
		    detectionArray = (JSONArray) detectionArray.get(0); //Eliminate extra brackets.
		    
		    for (int index=0; index<detectionArray.length();index++){
		    	JSONObject language = (JSONObject) detectionArray.get(index);
			    Detection newLanguage = mapper.fromJson(language.toString(), Detection.class);
		    	System.out.println(newLanguage.getLanguage());
			    detectedLanguages.add(newLanguage);
		    }
		    
		    return detectedLanguages;
	  }  
	  
	  public List<Detection> postDetectLanguage(String apiKey, String text ) {
		    WebResource webResource = getApiResource()
		    		.path("detect")
		    		.queryParam("key", apiKey)
		    		.queryParam("q", text);		    
		    List<Detection> detectedLanguages = new ArrayList<Detection>();
		    String initialReturn = execute(webResource, "POST", String.class);
		    JSONObject detections = (JSONObject) new JSONObject(initialReturn).get("data");
		    JSONArray detectionArray = (JSONArray) new JSONObject(detections.toString()).get("detections");
		    detectionArray = (JSONArray) detectionArray.get(0); //Eliminate extra brackets.
		    
		    for (int index=0; index<detectionArray.length();index++){
		    	JSONObject language = (JSONObject) detectionArray.get(index);
			    Detection newLanguage = mapper.fromJson(language.toString(), Detection.class);
		    	System.out.println(newLanguage.getLanguage());
			    detectedLanguages.add(newLanguage);
		    }
		    
		    return detectedLanguages;
	  }  


	  /**
     * Executes the Google Translate request 
     * Google Translate API requires "X-HTTP-Method-Override:GET" in the header to translate long text.
     */
    private <T> T execute(WebResource webResource, String method, Class<T> returnClass) {

    	WebResource.Builder builder = webResource.accept(MediaType.APPLICATION_JSON);
    	builder.type(MediaType.APPLICATION_JSON);
    	if (method.equals("POST")){
    	builder.header("X-HTTP-Method-Override", "GET");	
    	}

    	return builder.get(returnClass);
    }
  
	 public Client getClient() {
	        return client;
	    }

	    public void setClient(Client client) {
	        this.client = client;
	    }
	    
	    public WebResource getApiResource() {
	        return apiResource;
	    }

	    public void setApiResource(WebResource apiResource) {
	        this.apiResource = apiResource;
	    }
	    
	    public GoogleTranslateJerseyConnector getConnector() {
	        return connector;
	    }

	    public void setConnector(GoogleTranslateJerseyConnector connector) {
	        this.connector = connector;
	    }
	    

}
