/**
 * (c) 2003-2015 MuleSoft, Inc. The software in this package is published under the terms of the CPAL v1.0 license,
 * a copy of which has been included with this distribution in the LICENSE.md file.
 */

package org.mule.modules.googletranslatejersey.entities;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Detection {

    @SerializedName("language")
    @Expose
    private String language;
    @SerializedName("isReliable")
    @Expose
    private Boolean isReliable;
    @SerializedName("confidence")
    @Expose
    private Double confidence;

    /**
     * 
     * @return
     *     The language
     */
    public String getLanguage() {
        return language;
    }

    /**
     * 
     * @param language
     *     The language
     */
    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * 
     * @return
     *     The isReliable
     */
    public Boolean getIsReliable() {
        return isReliable;
    }

    /**
     * 
     * @param isReliable
     *     The isReliable
     */
    public void setIsReliable(Boolean isReliable) {
        this.isReliable = isReliable;
    }

    /**
     * 
     * @return
     *     The confidence
     */
    public Double getConfidence() {
        return confidence;
    }

    /**
     * 
     * @param confidence
     *     The confidence
     */
    public void setConfidence(Double confidence) {
        this.confidence = confidence;
    }

}
