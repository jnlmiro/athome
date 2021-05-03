package org.jorgma.athome.sl.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by jorgma on 2021-04-14.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DepartureDeviation {

    private int importanceLevel;
    private String text;
    private String deviationType;
    private String classification;

    public int getImportanceLevel() {
        return importanceLevel;
    }

    public void setImportanceLevel(int importanceLevel) {
        this.importanceLevel = importanceLevel;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDeviationType() {
        return deviationType;
    }

    public void setDeviationType(String deviationType) {
        this.deviationType = deviationType;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }
}


