package com.noetic.siteminder.domain.external;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.ManyToOne;

/**
 * Created by hurman on 04/08/2017.
 */
@Entity
@Table(name = "AvailabilityRoomFeed")
public class AvailabilityRoomFeed {

    @Id
    private String urn;
    private String hotelCode;
    private String hotelName;
    private String roomCode;
    private String roomDescription;
    private Integer availableCount;
    private String rateCode;
    private String rateDescription;
    private Long totalRate;
    private Integer roomCapacity;
    private Integer stayCount;
    private Long ratePerNight;
    private String client;
    private Boolean allowsExtraBed;

    @ManyToOne
    @JoinColumn(name = "availabilityUrn", nullable = false)
    private AvailabilityFeed availabilityUrn;

    public String getUrn() {
        return urn;
    }

    public void setUrn(String urn) {
        this.urn = urn;
    }

    public String getHotelCode() {
        return hotelCode;
    }

    public void setHotelCode(String hotelCode) {
        this.hotelCode = hotelCode;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getRoomCode() {
        return roomCode;
    }

    public void setRoomCode(String roomCode) {
        this.roomCode = roomCode;
    }

    public String getRoomDescription() {
        return roomDescription;
    }

    public void setRoomDescription(String roomDescription) {
        this.roomDescription = roomDescription;
    }

    public Integer getAvailableCount() {
        return availableCount;
    }

    public void setAvailableCount(Integer availableCount) {
        this.availableCount = availableCount;
    }

    public String getRateCode() {
        return rateCode;
    }

    public void setRateCode(String rateCode) {
        this.rateCode = rateCode;
    }

    public String getRateDescription() {
        return rateDescription;
    }

    public void setRateDescription(String rateDescription) {
        this.rateDescription = rateDescription;
    }

    public Long getTotalRate() {
        return totalRate;
    }

    public void setTotalRate(Long totalRate) {
        this.totalRate = totalRate;
    }

    public Integer getRoomCapacity() {
        return roomCapacity;
    }

    public void setRoomCapacity(Integer roomCapacity) {
        this.roomCapacity = roomCapacity;
    }

    public Integer getStayCount() {
        return stayCount;
    }

    public void setStayCount(Integer stayCount) {
        this.stayCount = stayCount;
    }

    public Long getRatePerNight() {
        return ratePerNight;
    }

    public void setRatePerNight(Long ratePerNight) {
        this.ratePerNight = ratePerNight;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public Boolean getAllowsExtraBed() {
        return allowsExtraBed;
    }

    public void setAllowsExtraBed(Boolean allowsExtraBed) {
        this.allowsExtraBed = allowsExtraBed;
    }

    public AvailabilityFeed getAvailabilityUrn() {
        return availabilityUrn;
    }

    public void setAvailabilityUrn(AvailabilityFeed availabilityUrn) {
        this.availabilityUrn = availabilityUrn;
    }

}
