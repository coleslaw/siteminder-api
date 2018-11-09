package com.noetic.dto.hospitality;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serializable;
import java.util.List;

/**
 * Created by hurman on 11/10/2017.
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "roomPromotions"
})
public class RoomPromotionPackageDTO implements Serializable {

    @JsonProperty("roomPromotions")
    private List<RoomPromotion> roomPromotions = null;

    @JsonProperty("roomPromotions")
    public List<RoomPromotion> getRoomPromotions() {
        return roomPromotions;
    }

    @JsonProperty("roomPromotions")
    public void setRoomPromotions(List<RoomPromotion> roomPromotions) {
        this.roomPromotions = roomPromotions;
    }

    public static class RoomPromotion {

        @JsonProperty("roomDetailUrn")
        private String roomDetailUrn;
        @JsonProperty("promotionDetailUrn")
        private String promotionDetailUrn;
        @JsonProperty("packages")
        private List<String> packages = null;

        @JsonProperty("roomDetailUrn")
        public String getRoomDetailUrn() {
            return roomDetailUrn;
        }

        @JsonProperty("roomDetailUrn")
        public void setRoomDetailUrn(String roomDetailUrn) {
            this.roomDetailUrn = roomDetailUrn;
        }

        @JsonProperty("promotionDetailUrn")
        public String getPromotionDetailUrn() {
            return promotionDetailUrn;
        }

        @JsonProperty("promotionDetailUrn")
        public void setPromotionDetailUrn(String promotionDetailUrn) {
            this.promotionDetailUrn = promotionDetailUrn;
        }

        @JsonProperty("packages")
        public List<String> getPackages() {
            return packages;
        }

        @JsonProperty("packages")
        public void setPackages(List<String> packages) {
            this.packages = packages;
        }

    }
}