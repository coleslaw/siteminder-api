package com.noetic.dto.hospitality;

/**
 * Created by hurman on 11/10/2017.
 */

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serializable;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "packages"
})
public class PackageDTO implements Serializable{

    @JsonProperty("packages")
    private List<Package> packages = null;

    @JsonProperty("packages")
    public List<Package> getPackages() {
        return packages;
    }

    @JsonProperty("packages")
    public void setPackages(List<Package> packages) {
        this.packages = packages;
    }

    public static class Package {

        @JsonProperty("urn")
        private String urn;
        @JsonProperty("packageName")
        private String packageName;
        @JsonProperty("packageCode")
        private String packageCode;
        @JsonProperty("cmsCode")
        private String cmsCode;
        @JsonProperty("category")
        private String category;
        @JsonProperty("categoryGroup")
        private String categoryGroup;
        @JsonProperty("type")
        private String type;
        @JsonProperty("paymentType")
        private String paymentType;
        @JsonProperty("increaseGuestCount")
        private String increaseGuestCount;
        @JsonProperty("itemCode")
        private String itemCode;
        @JsonProperty("requestCode")
        private String requestCode;
        @JsonProperty("startDate")
        private Long startDate;
        @JsonProperty("endDate")
        private Long endDate;

        @JsonProperty("urn")
        public String getUrn() {
            return urn;
        }

        @JsonProperty("urn")
        public void setUrn(String urn) {
            this.urn = urn;
        }

        @JsonProperty("packageName")
        public String getPackageName() {
            return packageName;
        }

        @JsonProperty("packageName")
        public void setPackageName(String packageName) {
            this.packageName = packageName;
        }

        @JsonProperty("packageCode")
        public String getPackageCode() {
            return packageCode;
        }

        @JsonProperty("packageCode")
        public void setPackageCode(String packageCode) {
            this.packageCode = packageCode;
        }

        @JsonProperty("cmsCode")
        public String getCmsCode() {
            return cmsCode;
        }

        @JsonProperty("cmsCode")
        public void setCmsCode(String cmsCode) {
            this.cmsCode = cmsCode;
        }

        @JsonProperty("category")
        public String getCategory() {
            return category;
        }

        @JsonProperty("category")
        public void setCategory(String category) {
            this.category = category;
        }

        @JsonProperty("categoryGroup")
        public String getCategoryGroup() {
            return categoryGroup;
        }

        @JsonProperty("categoryGroup")
        public void setCategoryGroup(String categoryGroup) {
            this.categoryGroup = categoryGroup;
        }

        @JsonProperty("type")
        public String getType() {
            return type;
        }

        @JsonProperty("type")
        public void setType(String type) {
            this.type = type;
        }

        @JsonProperty("paymentType")
        public String getPaymentType() {
            return paymentType;
        }

        @JsonProperty("paymentType")
        public void setPaymentType(String paymentType) {
            this.paymentType = paymentType;
        }

        @JsonProperty("increaseGuestCount")
        public String getIncreaseGuestCount() {
            return increaseGuestCount;
        }

        @JsonProperty("increaseGuestCount")
        public void setIncreaseGuestCount(String increaseGuestCount) {
            this.increaseGuestCount = increaseGuestCount;
        }

        @JsonProperty("itemCode")
        public String getItemCode() {
            return itemCode;
        }

        @JsonProperty("itemCode")
        public void setItemCode(String itemCode) {
            this.itemCode = itemCode;
        }

        @JsonProperty("requestCode")
        public String getRequestCode() {
            return requestCode;
        }

        @JsonProperty("requestCode")
        public void setRequestCode(String requestCode) {
            this.requestCode = requestCode;
        }

        @JsonProperty("startDate")
        public Long getStartDate() {
            return startDate;
        }

        @JsonProperty("startDate")
        public void setStartDate(Long startDate) {
            this.startDate = startDate;
        }

        @JsonProperty("endDate")
        public Long getEndDate() {
            return endDate;
        }

        @JsonProperty("endDate")
        public void setEndDate(Long endDate) {
            this.endDate = endDate;
        }
    }

}

