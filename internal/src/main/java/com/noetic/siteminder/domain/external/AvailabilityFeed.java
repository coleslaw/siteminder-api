package com.noetic.siteminder.domain.external;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import java.util.List;

/**
 * Created by hurman on 04/08/2017.
 */
@Entity
@Table(name = "AvailabilityFeed")
public class AvailabilityFeed {

    @Id
    private String urn;
    private Long updated;
    private Boolean completed;
    private Long checkIn;
    private Long checkOut;
    private String client;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "availabilityUrn", nullable = true)
    private List<AvailabilityRoomFeed> availabilityRoomFeed;

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

    public List<AvailabilityRoomFeed> getAvailabilityRoomFeed() {
        return availabilityRoomFeed;
    }

    public void setAvailabilityRoomFeed(List<AvailabilityRoomFeed> availabilityRoomFeed) {
        this.availabilityRoomFeed = availabilityRoomFeed;
    }
}
