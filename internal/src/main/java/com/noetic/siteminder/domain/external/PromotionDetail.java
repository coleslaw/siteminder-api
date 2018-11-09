package com.noetic.siteminder.domain.external;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

/**
 * Created by hurman on 16/10/2017.
 */
@Entity
@Table(name = "PromotionDetail")
public class PromotionDetail implements Serializable {

    @Id
    private String urn;
    private String promotionName;
    private String promotionCode;
    private String requestCode;
    private String cmsCode;
    private boolean refundable;
    private Long startDate;
    private Long endDate;
    private String promotionType;
    private boolean voucher;
    private Long onSaleFrom;
    private Long onSaleTo;
    private boolean isActive;
    

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "promotionCode", referencedColumnName = "promotionCode",
            nullable = false, insertable = false, updatable = false)
    private CancelPolicy cancelPolicy;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "promotionDetailUrn", nullable = true, insertable = false, updatable = false)
    private List<RoomPromotionDetail> roomPromotionDetailList;

    public String getUrn() {
        return urn;
    }

    public void setUrn(String urn) {
        this.urn = urn;
    }

    public String getPromotionName() {
        return promotionName;
    }

    public void setPromotionName(String promotionName) {
        this.promotionName = promotionName;
    }

    public String getPromotionCode() {
        return promotionCode;
    }

    public void setPromotionCode(String promotionCode) {
        this.promotionCode = promotionCode;
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

    public boolean isRefundable() {
        return refundable;
    }

    public void setRefundable(boolean refundable) {
        this.refundable = refundable;
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

    public String getPromotionType() {
        return promotionType;
    }

    public void setPromotionType(String promotionType) {
        this.promotionType = promotionType;
    }

    public boolean isVoucher() {
        return voucher;
    }

    public void setVoucher(boolean voucher) {
        this.voucher = voucher;
    }

    public CancelPolicy getCancelPolicy() {
        return cancelPolicy;
    }

    public void setCancelPolicy(CancelPolicy cancelPolicy) {
        this.cancelPolicy = cancelPolicy;
    }

    public List<RoomPromotionDetail> getRoomPromotionDetailList() {
        return roomPromotionDetailList;
    }

    public void setRoomPromotionDetailList(List<RoomPromotionDetail> roomPromotionDetailList) {
        this.roomPromotionDetailList = roomPromotionDetailList;
    }

    public Long getOnSaleFrom() {
        return onSaleFrom;
    }

    public void setOnSaleFrom(Long onSaleFrom) {
        this.onSaleFrom = onSaleFrom;
    }

    public Long getOnSaleTo() {
        return onSaleTo;
    }

    public void setOnSaleTo(Long onSaleTo) {
        this.onSaleTo = onSaleTo;
    }

   public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }
}
