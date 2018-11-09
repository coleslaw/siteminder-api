package com.noetic.dto;

import com.noetic.dto.hospitality.PromotionDTO;
import com.noetic.dto.hospitality.RoomDTO;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * Created by hurman on 26/10/2017.
 */
public class HospitalityMeta implements Serializable {

    private List<PromotionMeta> promotionMetaList;
    private List<PackageMeta> packageMetaList;
    private List<RoomMeta> roomMetaList;
    private List<RoomPromotionMeta> roomPromotionMetaList;

    public static class PromotionMeta implements Serializable {

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
        private List<PromotionDTO.Name> names;
        private List<PromotionDTO.Description> descriptions;
        private boolean containsParking;
        private boolean containsBreakfast;
        private boolean containsInternet;
        private Long onSaleFrom;
        private Long onSaleTo;
        private boolean isActive;

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

        public List<PromotionDTO.Name> getNames() {
            return names;
        }

        public void setNames(List<PromotionDTO.Name> names) {
            this.names = names;
        }

        public List<PromotionDTO.Description> getDescriptions() {
            return descriptions;
        }

        public void setDescriptions(List<PromotionDTO.Description> descriptions) {
            this.descriptions = descriptions;
        }

        public boolean isContainsParking() {
            return containsParking;
        }

        public void setContainsParking(boolean containsParking) {
            this.containsParking = containsParking;
        }

        public boolean isContainsBreakfast() {
            return containsBreakfast;
        }

        public void setContainsBreakfast(boolean containsBreakfast) {
            this.containsBreakfast = containsBreakfast;
        }

        public boolean isContainsInternet() {
            return containsInternet;
        }

        public void setContainsInternet(boolean containsInternet) {
            this.containsInternet = containsInternet;
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

    public static class PackageMeta implements Serializable {

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
        private boolean containsParking;
        private boolean containsBreakfast;

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

        public boolean isContainsParking() {
            return containsParking;
        }

        public void setContainsParking(boolean containsParking) {
            this.containsParking = containsParking;
        }

        public boolean isContainsBreakfast() {
            return containsBreakfast;
        }

        public void setContainsBreakfast(boolean containsBreakfast) {
            this.containsBreakfast = containsBreakfast;
        }
    }

    public static class RoomMeta implements Serializable{

        private String urn;
        private String hotel;
        private String roomCode;
        private List<RoomDTO.Name> names;
        private List<RoomDTO.Description> descriptions;
        private String photoUrl;
        private List<RoomDTO.Caption> captions;

        public String getUrn() {
            return urn;
        }

        public void setUrn(String urn) {
            this.urn = urn;
        }

        public String getHotel() {
            return hotel;
        }

        public void setHotel(String hotel) {
            this.hotel = hotel;
        }

        public String getRoomCode() {
            return roomCode;
        }

        public void setRoomCode(String roomCode) {
            this.roomCode = roomCode;
        }

        public List<RoomDTO.Name> getNames() {
            return names;
        }

        public void setNames(List<RoomDTO.Name> names) {
            this.names = names;
        }

        public List<RoomDTO.Description> getDescriptions() {
            return descriptions;
        }

        public void setDescriptions(List<RoomDTO.Description> descriptions) {
            this.descriptions = descriptions;
        }

        public String getPhotoUrl() {
            return photoUrl;
        }

        public void setPhotoUrl(String photoUrl) {
            this.photoUrl = photoUrl;
        }

        public List<RoomDTO.Caption> getCaptions() {
            return captions;
        }

        public void setCaptions(List<RoomDTO.Caption> captions) {
            this.captions = captions;
        }
    }

    public static class RoomPromotionMeta implements Serializable{

        private String roomUrn;
        private String roomCode;
        private String promotionUrn;
        private String promotionCode;
        private String hotelCode;
        private List<PackageMeta> packages;
        private boolean containsParking;
        private boolean containsBreakfast;
        private boolean containsInternet;

        public String getRoomUrn() {
            return roomUrn;
        }

        public void setRoomUrn(String roomUrn) {
            this.roomUrn = roomUrn;
        }

        public String getRoomCode() {
            return roomCode;
        }

        public void setRoomCode(String roomCode) {
            this.roomCode = roomCode;
        }

        public String getPromotionUrn() {
            return promotionUrn;
        }

        public void setPromotionUrn(String promotionUrn) {
            this.promotionUrn = promotionUrn;
        }

        public String getPromotionCode() {
            return promotionCode;
        }

        public void setPromotionCode(String promotionCode) {
            this.promotionCode = promotionCode;
        }

        public List<PackageMeta> getPackages() {
            return packages;
        }

        public void setPackages(List<PackageMeta> packages) {
            this.packages = packages;
        }

        public boolean isContainsParking() {
            return containsParking;
        }

        public void setContainsParking(boolean containsParking) {
            this.containsParking = containsParking;
        }

        public boolean isContainsBreakfast() {
            return containsBreakfast;
        }

        public void setContainsBreakfast(boolean containsBreakfast) {
            this.containsBreakfast = containsBreakfast;
        }

        public boolean isContainsInternet() {
            return containsInternet;
        }

        public void setContainsInternet(boolean containsInternet) {
            this.containsInternet = containsInternet;
        }

        public String getHotelCode() {
            return hotelCode;
        }

        public void setHotelCode(String hotelCode) {
            this.hotelCode = hotelCode;
        }
    }

    public List<PromotionMeta> getPromotionMetaList() {
        return promotionMetaList;
    }

    public void setPromotionMetaList(List<PromotionMeta> promotionMetaList) {
        this.promotionMetaList = promotionMetaList;
    }

    public List<PackageMeta> getPackageMetaList() {
        return packageMetaList;
    }

    public void setPackageMetaList(List<PackageMeta> packageMetaList) {
        this.packageMetaList = packageMetaList;
    }

    public List<RoomMeta> getRoomMetaList() {
        return roomMetaList;
    }

    public void setRoomMetaList(List<RoomMeta> roomMetaList) {
        this.roomMetaList = roomMetaList;
    }

    public List<RoomPromotionMeta> getRoomPromotionMetaList() {
        return roomPromotionMetaList;
    }

    public void setRoomPromotionMetaList(List<RoomPromotionMeta> roomPromotionMetaList) {
        this.roomPromotionMetaList = roomPromotionMetaList;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof HospitalityMeta)) {
            return false;
        }

        HospitalityMeta that = (HospitalityMeta) o;
        return Objects.equals(getPromotionMetaList(), that.getPromotionMetaList()) &&
                Objects.equals(getPackageMetaList(), that.getPackageMetaList()) &&
                Objects.equals(getRoomMetaList(), that.getRoomMetaList()) &&
                Objects.equals(getRoomPromotionMetaList(), that.getRoomPromotionMetaList());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPromotionMetaList(),
                getPackageMetaList(),
                getRoomMetaList(),
                getRoomPromotionMetaList());
    }
}
