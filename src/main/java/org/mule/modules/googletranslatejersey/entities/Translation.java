package org.mule.modules.googletranslatejersey.entities;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Translation {

@SerializedName("translatedText")
@Expose
private String translatedText;

/**
* 
* @return
* The translatedText
*/
public String getTranslatedText() {
return translatedText;
}

/**
* 
* @param translatedText
* The translatedText
*/
public void setTranslatedText(String translatedText) {
this.translatedText = translatedText;
}

}