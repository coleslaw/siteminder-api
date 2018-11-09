package com.noetic.dto.hospitality;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serializable;
import java.util.List;

/**
 * Created by hurman on 02/10/2017.
 */
public class PromotionDTO implements Serializable{

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonPropertyOrder({
            "code",
            "names",
            "descriptions"
    })

    @JsonProperty("urn")
    private String urn;
    @JsonProperty("code")
    private String code;
    @JsonProperty("names")
    private List<Name> names = null;
    @JsonProperty("descriptions")
    private List<Description> descriptions = null;

    @JsonProperty("urn")
    public String getUrn() {
        return urn;
    }

    @JsonProperty("urn")
    public void setUrn(String urn) {
        this.urn = urn;
    }

    @JsonProperty("code")
    public String getCode() {
        return code;
    }

    @JsonProperty("code")
    public void setCode(String code) {
        this.code = code;
    }

    @JsonProperty("names")
    public List<Name> getNames() {
        return names;
    }

    @JsonProperty("names")
    public void setNames(List<Name> names) {
        this.names = names;
    }

    @JsonProperty("descriptions")
    public List<Description> getDescriptions() {
        return descriptions;
    }

    @JsonProperty("descriptions")
    public void setDescriptions(List<Description> descriptions) {
        this.descriptions = descriptions;
    }

    @Override
    public String toString() {
        return "PromotionDTO{" +
                "code='" + code + '\'' +
                ", names=" + names +
                ", descriptions=" + descriptions +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {return true; }
        if (o == null || getClass() != o.getClass()) {return false; }

        PromotionDTO that = (PromotionDTO) o;

        return code != null ? code.equals(that.code) : that.code == null;
    }

    @Override
    public int hashCode() {
        return code != null ? code.hashCode() : 0;
    }

    public static class Description implements Serializable{

        @JsonProperty("text")
        private String text;
        @JsonProperty("language")
        private String language;

        @JsonProperty("text")
        public String getText() {
            return text;
        }

        @JsonProperty("text")
        public void setText(String text) {
            this.text = text;
        }

        @JsonProperty("language")
        public String getLanguage() {
            return language;
        }

        @JsonProperty("language")
        public void setLanguage(String language) {
            this.language = language;
        }

    }

    public static class Name implements Serializable{

        @JsonProperty("text")
        private String text;
        @JsonProperty("language")
        private String language;

        @JsonProperty("text")
        public String getText() {
            return text;
        }

        @JsonProperty("text")
        public void setText(String text) {
            this.text = text;
        }

        @JsonProperty("language")
        public String getLanguage() {
            return language;
        }

        @JsonProperty("language")
        public void setLanguage(String language) {
            this.language = language;
        }

    }

}