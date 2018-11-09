package com.noetic.dto.hospitality;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serializable;
import java.util.List;

/**
 * Created by hurman on 02/10/2017.
 */
public class RoomDTO implements Serializable {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonPropertyOrder({
            "urn",
            "hotel",
            "roomCode",
            "names",
            "descriptions",
            "photoUrl",
            "captions"
    })

    @JsonProperty("urn")
    private String urn;
    @JsonProperty("hotel")
    private String hotel;
    @JsonProperty("roomCode")
    private String roomCode;
    @JsonProperty("names")
    private List<Name> names = null;
    @JsonProperty("descriptions")
    private List<Description> descriptions = null;
    @JsonProperty("photoUrl")
    private String photoUrl;
    @JsonProperty("captions")
    private List<Caption> captions = null;

    @JsonProperty("urn")
    public String getUrn() {
        return urn;
    }

    @JsonProperty("urn")
    public void setUrn(String urn) {
        this.urn = urn;
    }

    @JsonProperty("hotel")
    public String getHotel() {
        return hotel;
    }

    @JsonProperty("hotel")
    public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    @JsonProperty("roomCode")
    public String getRoomCode() {
        return roomCode;
    }

    @JsonProperty("roomCode")
    public void setRoomCode(String roomCode) {
        this.roomCode = roomCode;
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

    @JsonProperty("photoUrl")
    public String getPhotoUrl() {
        return photoUrl;
    }

    @JsonProperty("photoUrl")
    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    @JsonProperty("captions")
    public List<Caption> getCaptions() {
        return captions;
    }

    @JsonProperty("captions")
    public void setCaptions(List<Caption> captions) {
        this.captions = captions;
    }

    @Override
    public String toString() {
        return "RoomDTO{" +
                "urn='" + urn + '\'' +
                ", hotel='" + hotel + '\'' +
                ", roomCode='" + roomCode + '\'' +
                ", names=" + names +
                ", descriptions=" + descriptions +
                ", photoUrl='" + photoUrl + '\'' +
                ", captions=" + captions +
                '}';
    }

    public static class Caption implements Serializable {

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