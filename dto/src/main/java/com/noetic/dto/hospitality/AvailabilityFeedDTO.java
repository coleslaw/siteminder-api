package com.noetic.dto.hospitality;

import java.io.Serializable;
import java.util.List;

/**
 * Created by hurman on 09/08/2017.
 */
public class AvailabilityFeedDTO implements Serializable {

    private String urn;
    private Long updated;
    private Boolean completed;
    private Long checkIn;
    private Long checkOut;
    private String client;
    private List<AvailabilityRoomFeedDTO> availabilityRoomFeed;

    public String getUrn() {
        return urn;
    }

    public void setUrn(String urn) {
        this.urn = urn;
    }

    public Long getUpdated() {
        return updated;
    }

    public void setUpdated(Long updated) {
        this.updated = updated;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public Long getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Long checkIn) {
        this.checkIn = checkIn;
    }

    public Long getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Long checkOut) {
        this.checkOut = checkOut;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public List<AvailabilityRoomFeedDTO> getAvailabilityRoomFeed() {
        return availabilityRoomFeed;
    }

    public void setAvailabilityRoomFeed(List<AvailabilityRoomFeedDTO> availabilityRoomFeed) {
        this.availabilityRoomFeed = availabilityRoomFeed;
    }
}
