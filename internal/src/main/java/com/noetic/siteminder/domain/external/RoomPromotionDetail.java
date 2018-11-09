package com.noetic.siteminder.domain.external;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Created by hurman on 13/10/2017.
 */
@Entity
@Table(name = "RoomPromotionDetail")
public class RoomPromotionDetail {

    @Id
    private String id;
    private String roomDetailUrn;
    private String promotionDetailUrn;
    private String packageDetailUrn;

    @Transient
    @ManyToOne
    @JoinColumn(name = "promotionDetailUrn",
            nullable = false, insertable = false, updatable = false)
    private PromotionDetail promotionDetail;


    @ManyToOne
    @JoinColumn(name = "packageDetailUrn",
            nullable = false, insertable = false, updatable = false)
    private PackageDetail packageDetail;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoomDetailUrn() {
        return roomDetailUrn;
    }

    public void setRoomDetailUrn(String roomDetailUrn) {
        this.roomDetailUrn = roomDetailUrn;
    }

    public String getPromotionDetailUrn() {
        return promotionDetailUrn;
    }

    public void setPromotionDetailUrn(String promotionDetailUrn) {
        this.promotionDetailUrn = promotionDetailUrn;
    }

    public String getPackageDetailUrn() {
        return packageDetailUrn;
    }

    public void setPackageDetailUrn(String packageDetailUrn) {
        this.packageDetailUrn = packageDetailUrn;
    }

    public PromotionDetail getPromotionDetail() {
        return promotionDetail;
    }

    public void setPromotionDetail(PromotionDetail promotionDetail) {
        this.promotionDetail = promotionDetail;
    }

    public PackageDetail getPackageDetail() {
        return packageDetail;
    }

    public void setPackageDetail(PackageDetail packageDetail) {
        this.packageDetail = packageDetail;
    }
}
