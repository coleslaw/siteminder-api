package com.noetic.siteminder.domain.external;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by hurman on 13/10/2017.
 */
@Entity
@Table(name = "CancelPolicy")
public class CancelPolicy implements Serializable {

    @Id
    private String urn;
    private String siteSetupUrn;
    private String promotionCode;
    private String cutoffTimeOfDay;
    private Integer individualCancelDays;
    private Integer groupCancelDays;

    @OneToOne
    @JoinColumn(name = "promotionCode", referencedColumnName = "promotionCode",
            nullable = false, insertable = false, updatable = false)
    private PromotionDetail promotionDetail;

    public String getUrn() {
        return urn;
    }

    public void setUrn(String urn) {
        this.urn = urn;
    }

    public String getSiteSetupUrn() {
        return siteSetupUrn;
    }

    public void setSiteSetupUrn(String siteSetupUrn) {
        this.siteSetupUrn = siteSetupUrn;
    }

    public String getPromotionCode() {
        return promotionCode;
    }

    public void setPromotionCode(String promotionCode) {
        this.promotionCode = promotionCode;
    }

    public String getCutoffTimeOfDay() {
        return cutoffTimeOfDay;
    }

    public void setCutoffTimeOfDay(String cutoffTimeOfDay) {
        this.cutoffTimeOfDay = cutoffTimeOfDay;
    }

    public Integer getIndividualCancelDays() {
        return individualCancelDays;
    }

    public void setIndividualCancelDays(Integer individualCancelDays) {
        this.individualCancelDays = individualCancelDays;
    }

    public Integer getGroupCancelDays() {
        return groupCancelDays;
    }

    public void setGroupCancelDays(Integer groupCancelDays) {
        this.groupCancelDays = groupCancelDays;
    }

    public PromotionDetail getPromotionDetail() {
        return promotionDetail;
    }

    public void setPromotionDetail(PromotionDetail promotionDetail) {
        this.promotionDetail = promotionDetail;
    }
}
