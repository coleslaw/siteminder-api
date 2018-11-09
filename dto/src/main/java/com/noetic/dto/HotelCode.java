package com.noetic.dto;

import java.io.Serializable;

/**
 * Created by hurman on 30/08/2017.
 */
public enum HotelCode implements Serializable {

    BEDFORD {
        @Override
        public String getCode() {
            return "BEDFORD";
        }
    },
    COUNTY {
        @Override
        public String getCode() {
            return "COUNTY";
        }
    },
    IMPERIAL {
        @Override
        public String getCode() {
            return "IMPERIAL";
        }
    },
    PRES {
        @Override
        public String getCode() {
            return "PRES";
        }
    },
    ROYAL {
        @Override
        public String getCode() {
            return "ROYAL";
        }
    },
    TAVIS {
        @Override
        public String getCode() {
            return "TAVIS";
        }
    },
    MORTON {
        @Override
        public String getCode() {
            return "MORTON";
        }
    };

    public abstract String getCode();

    public static HotelCode value(String name) {
        return HotelCode.valueOf(name.toUpperCase());
    }
}