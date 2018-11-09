package com.noetic.siteminder.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.noetic.dto.HospitalityMeta;
import com.noetic.dto.hospitality.CancellationPolicyDTO;
import com.noetic.dto.hospitality.PackageDTO;
import com.noetic.dto.hospitality.PromotionDTO;
import com.noetic.dto.hospitality.RoomDTO;
import com.noetic.dto.hospitality.RoomPromotionPackageDTO;

/**
 * Created by hurman on 02/10/2017.
 */
public interface ImperialService {

    ArrayList<RoomDTO> fetchRoomInfo() throws Exception;

    ArrayList<PromotionDTO> fetchPromotionInfo() throws Exception;

    CancellationPolicyDTO fetchCancellationPolicy() throws Exception;

    RoomPromotionPackageDTO fetchRoomPromotionsAndPackages() throws Exception;

    PackageDTO fetchPackageInfo() throws Exception;

    HospitalityMeta fetchAvailabilityMetaEnriched() throws Exception;

    HospitalityMeta fetchAvailabilityMetaCached() throws Exception;
    
    List<HospitalityMeta.PromotionMeta> getValidPromotions(List<HospitalityMeta.PromotionMeta> promoList,
            String checkIndDate, int numOfNights) throws ParseException;

}
