package com.noetic.dto.hospitality;

/**
 * Created by hurman on 05/10/2017.
 */
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serializable;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "cancelPolicies"
})
public class CancellationPolicyDTO implements Serializable {

    public CancellationPolicyDTO() {
    }

    public CancellationPolicyDTO(List<CancelPolicy> cancelPolicies) {
        this.cancelPolicies = cancelPolicies;
    }

    @JsonProperty("cancelPolicies")
    private List<CancelPolicy> cancelPolicies = null;

    @JsonProperty("cancelPolicies")
    public List<CancelPolicy> getCancelPolicies() {
        return cancelPolicies;
    }

    @JsonProperty("cancelPolicies")
    public void setCancelPolicies(List<CancelPolicy> cancelPolicies) {
        this.cancelPolicies = cancelPolicies;
    }

    public static class CancelPolicy {

        @JsonProperty("urn")
        private String urn;
        @JsonProperty("siteSetupUrn")
        private String siteSetupUrn;
        @JsonProperty("promotionCode")
        private Object promotionCode;
        @JsonProperty("cutoffTimeOfDay")
        private String cutoffTimeOfDay;
        @JsonProperty("individualCancelDays")
        private Integer individualCancelDays;
        @JsonProperty("groupCancelDays")
        private Integer groupCancelDays;

        @JsonProperty("urn")
        public String getUrn() {
            return urn;
        }

        @JsonProperty("urn")
        public void setUrn(String urn) {
            this.urn = urn;
        }

        @JsonProperty("siteSetupUrn")
        public String getSiteSetupUrn() {
            return siteSetupUrn;
        }

        @JsonProperty("siteSetupUrn")
        public void setSiteSetupUrn(String siteSetupUrn) {
            this.siteSetupUrn = siteSetupUrn;
        }

        @JsonProperty("promotionCode")
        public Object getPromotionCode() {
            return promotionCode;
        }

        @JsonProperty("promotionCode")
        public void setPromotionCode(Object promotionCode) {
            this.promotionCode = promotionCode;
        }

        @JsonProperty("cutoffTimeOfDay")
        public String getCutoffTimeOfDay() {
            return cutoffTimeOfDay;
        }

        @JsonProperty("cutoffTimeOfDay")
        public void setCutoffTimeOfDay(String cutoffTimeOfDay) {
            this.cutoffTimeOfDay = cutoffTimeOfDay;
        }

        @JsonProperty("individualCancelDays")
        public Integer getIndividualCancelDays() {
            return individualCancelDays;
        }

        @JsonProperty("individualCancelDays")
        public void setIndividualCancelDays(Integer individualCancelDays) {
            this.individualCancelDays = individualCancelDays;
        }

        @JsonProperty("groupCancelDays")
        public Integer getGroupCancelDays() {
            return groupCancelDays;
        }

        @JsonProperty("groupCancelDays")
        public void setGroupCancelDays(Integer groupCancelDays) {
            this.groupCancelDays = groupCancelDays;
        }
    }
}
