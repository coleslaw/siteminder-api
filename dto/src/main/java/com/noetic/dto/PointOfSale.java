package com.noetic.dto;

import java.io.Serializable;

/**
 * Created by hurman on 31/10/2017.
 */
public enum PointOfSale implements Serializable {

    DEV_BEDFORD("Dev_Bedford_Hotel"),
    DEV_COUNTY("Dev_County_Hotel"),
    DEV_IMPERIAL("Dev_Imperial_Hotel"),
    DEV_PRES("Dev_President_Hotel"),
    DEV_ROYAL("Dev_Royal_National_Hotel"),
    DEV_TAVIS("Dev_Tavistock_Hotel"),
    DEV_MORTON("Dev_Morton_Hotel"),
    STAGING_BEDFORD("Staging_Bedford_Hotel"),
    STAGING_COUNTY("Staging_County_Hotel"),
    STAGING_IMPERIAL("Staging_Imperial_Hotel"),
    STAGING_PRES("Staging_President_Hotel"),
    STAGING_ROYAL("Staging_Royal_National_Hotel"),
    STAGING_TAVIS("Staging_Tavistock_Hotel"),
    STAGING_MORTON("Staging_Morton_Hotel"),
    BEDFORD("Bedford_Hotel"),
    COUNTY("County_Hotel"),
    IMPERIAL("Imperial_Hotel"),
    PRES("President_Hotel"),
    ROYAL("Royal_National_Hotel"),
    TAVIS("Tavistock_Hotel"),
    MORTON("Morton_Hotel");

    private final String pointOfSaleId;

    private PointOfSale(final String pointOfSaleId) {
        this.pointOfSaleId = pointOfSaleId;
    }

    public String getPointOfSaleId() {
        return pointOfSaleId;
    }

    @Override
    public String toString() {
        return pointOfSaleId;
    }

}
