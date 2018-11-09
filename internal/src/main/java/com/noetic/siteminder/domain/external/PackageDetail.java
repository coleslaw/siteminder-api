package com.noetic.siteminder.domain.external;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.List;

/**
 * Created by hurman on 13/10/2017.
 */
@Entity
@Table(name = "PackageDetail")
public class PackageDetail {

    @Id
    private String urn;
    private String packageName;
    private String packageCode;
    private String itemCode;
    private String requestCode;
    private String cmsCode;
    private String category;
    private String categoryGroup;
    private String type;
    private String paymentType;
    private String increaseGuestCount;
    private Long startDate;
    private Long endDate;

    @Transient
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "packageDetailUrn", nullable = true, insertable = false, updatable = false)
    private List<RoomPromotionDetail> roomPromotionDetailList;

    public String getUrn() {
        return urn;
    }

    public void setUrn(String urn) {
        this.urn = urn;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getPackageCode() {
        return packageCode;
    }

    public void setPackageCode(String packageCode) {
        this.packageCode = packageCode;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getRequestCode() {
        return requestCode;
    }

    public void setRequestCode(String requestCode) {
        this.requestCode = requestCode;
    }

    public String getCmsCode() {
        return cmsCode;
    }

    public void setCmsCode(String cmsCode) {
        this.cmsCode = cmsCode;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategoryGroup() {
        return categoryGroup;
    }

    public void setCategoryGroup(String categoryGroup) {
        this.categoryGroup = categoryGroup;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getIncreaseGuestCount() {
        return increaseGuestCount;
    }

    public void setIncreaseGuestCount(String increaseGuestCount) {
        this.increaseGuestCount = increaseGuestCount;
    }

    public Long getStartDate() {
        return startDate;
    }

    public void setStartDate(Long startDate) {
        this.startDate = startDate;
    }

    public Long getEndDate() {
        return endDate;
    }

    public void setEndDate(Long endDate) {
        this.endDate = endDate;
    }

    public List<RoomPromotionDetail> getRoomPromotionDetailList() {
        return roomPromotionDetailList;
    }

    public void setRoomPromotionDetailList(List<RoomPromotionDetail> roomPromotionDetailList) {
        this.roomPromotionDetailList = roomPromotionDetailList;
    }
}
