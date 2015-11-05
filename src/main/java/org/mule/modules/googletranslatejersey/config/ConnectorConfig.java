/**
 * (c) 2003-2015 MuleSoft, Inc. The software in this package is published under the terms of the CPAL v1.0 license,
 * a copy of which has been included with this distribution in the LICENSE.md file.
 */
package org.mule.modules.googletranslatejersey.config;

import org.mule.api.annotations.components.Configuration;
import org.mule.api.annotations.Configurable;
import org.mule.api.annotations.param.Default;
import org.mule.api.annotations.param.Optional;

@Configuration(friendlyName = "Configuration", configElementName = "config-with-apiKey")
public class ConnectorConfig {
	/**
	 * Google Translate API Url
	 */
	@Configurable @Optional @Default("https://www.googleapis.com/language/translate")
	private String apiUrl;

	/**
	 * Google Translate API version
	 */
	@Configurable @Optional @Default("v2")
	private String apiVersion;
	
	/**
	 * The APIKey
	 */
	@Configurable
	private String apiKey;
	
	public void setApiUrl(String apiUrl){
		this.apiUrl=apiUrl;
	}
	
	public String getApiUrl(){
		return this.apiUrl;
	}
	public void setApiVersion(String apiVersion){
		this.apiVersion=apiVersion;
	}
	
	public String getApiVersion(){
		return this.apiVersion;
	}
	public void setApiKey(String apiKey){
		this.apiKey=apiKey;
	}
	
	public String getApiKey(){
		return this.apiKey;
	}
	
	

}