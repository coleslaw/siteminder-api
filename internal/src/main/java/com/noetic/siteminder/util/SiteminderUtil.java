package com.noetic.siteminder.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.UUID;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.noetic.dto.PointOfSale;
import com.noetic.exception.InvalidInputExceptionJson;

/**
 * Created by Ruwan on 9/8/18.
 */
public class SiteminderUtil {

    private static Logger log = LoggerFactory.getLogger(SiteminderUtil.class);
    private static final Double TAX_AMOUNT = 0.2;

    public static boolean isFileExist(String fileNameAndLocation) {
        boolean isFileExist = false;
        try {
            File file = new File(fileNameAndLocation);
            if (file.exists()) {
                isFileExist = true;
            }
        } catch(Exception e) {
            log.warn("File does not exist {}", e.getMessage());
            isFileExist = false;
        }

        return isFileExist;
    }

    public static Long timeStampGenerator() {
        Calendar cal = Calendar.getInstance();
        return cal.getTimeInMillis();
    }

    public static String convertStreamToString(InputStream is)  throws InvalidInputExceptionJson {

        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();

        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
        } catch (IOException e) {
            throw (new InvalidInputExceptionJson(e.getMessage()));
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                throw (new InvalidInputExceptionJson(e.getMessage()));
            }
        }
        return sb.toString();
    }

    public static String urnGenerator() {
        Calendar cal = Calendar.getInstance();
        String val = String.valueOf(cal.getTimeInMillis());
        val += "-";
        cal.getTime();
        val += UUID.randomUUID().toString().replaceAll("-", "");
        return val;
    }

    public static String convertEpochToIso8601Date(Long date) {
        return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.ENGLISH).format(new Date(date).getTime());
    }

    public static String convertToShortDate(Long date) {
        return new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).format(new Date(date).getTime());
    }

    public static Double calculateBaseRate(Long totalRate) {
        return round((totalRate / 100) / (1 + TAX_AMOUNT), 2);
    }

    public static Double calculateTax(Long totalRate, Double baserate) {
        return round((totalRate / 100) - baserate, 2);
    }

    public static double round(double value, int places) {
        if (places < 0) {throw new IllegalArgumentException(); }

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    public static String getMatchedPointOfSale(String hotelCode, String deployProfile) {

        String pointOfSaleId = "";

        switch(deployProfile) {
            case "LOCAL":
            case "DEV":
                switch(hotelCode) {
                    case "BEDFORD":
                        pointOfSaleId = PointOfSale.DEV_BEDFORD.toString();
                        break;
                    case "COUNTY":
                        pointOfSaleId = PointOfSale.DEV_COUNTY.toString();
                        break;
                    case "IMPERIAL":
                        pointOfSaleId = PointOfSale.DEV_IMPERIAL.toString();
                        break;
                    case "PRES":
                        pointOfSaleId = PointOfSale.DEV_PRES.toString();
                        break;
                    case "ROYAL":
                        pointOfSaleId = PointOfSale.DEV_ROYAL.toString();
                        break;
                    case "TAVIS":
                        pointOfSaleId = PointOfSale.DEV_TAVIS.toString();
                        break;
                    case "MORTON":
                        pointOfSaleId = PointOfSale.DEV_MORTON.toString();
                        break;
                }
                break;
            case "STAGING":
                switch(hotelCode) {
                    case "BEDFORD":
                        pointOfSaleId = PointOfSale.STAGING_BEDFORD.toString();
                        break;
                    case "COUNTY":
                        pointOfSaleId = PointOfSale.STAGING_COUNTY.toString();
                        break;
                    case "IMPERIAL":
                        pointOfSaleId = PointOfSale.STAGING_IMPERIAL.toString();
                        break;
                    case "PRES":
                        pointOfSaleId = PointOfSale.STAGING_PRES.toString();
                        break;
                    case "ROYAL":
                        pointOfSaleId = PointOfSale.STAGING_ROYAL.toString();
                        break;
                    case "TAVIS":
                        pointOfSaleId = PointOfSale.STAGING_TAVIS.toString();
                        break;
                    case "MORTON":
                        pointOfSaleId = PointOfSale.STAGING_MORTON.toString();
                        break;
                }
                break;
            case "PRELIVE":
            case "PRODUCTION":
                switch(hotelCode) {
                    case "BEDFORD":
                        pointOfSaleId = PointOfSale.BEDFORD.toString();
                        break;
                    case "COUNTY":
                        pointOfSaleId = PointOfSale.COUNTY.toString();
                        break;
                    case "IMPERIAL":
                        pointOfSaleId = PointOfSale.IMPERIAL.toString();
                        break;
                    case "PRES":
                        pointOfSaleId = PointOfSale.PRES.toString();
                        break;
                    case "ROYAL":
                        pointOfSaleId = PointOfSale.ROYAL.toString();
                        break;
                    case "TAVIS":
                        pointOfSaleId = PointOfSale.TAVIS.toString();
                        break;
                    case "MORTON":
                        pointOfSaleId = PointOfSale.MORTON.toString();
                        break;
                }
                break;
        }

        return pointOfSaleId;
    }

    public static boolean isNullOrWhiteSpace(String string) {

        boolean retVal = false;

        if (string == null) {
            retVal = true;
        } else if (string.isEmpty()) {
            retVal = true;
        } else if (string.trim().equalsIgnoreCase("")) {
            retVal = true;
        } else if (string.length() == 0) {
            retVal = true;
        }

        return retVal;
    }

    public static Long convertShortDateToEpoch(String dateString) {

        Long dateMillis = null;
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
        TimeZone gmtTime = TimeZone.getTimeZone("GMT");
        format.setTimeZone(gmtTime);
        try {
            Date date = format.parse(dateString + " 00:00:00");
            dateMillis = date.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return dateMillis;
    }
    
    public static Date getDateWithoutTime(Date day) throws ParseException {
    	DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        return formatter.parse(formatter.format(day));
    }
    
    public static boolean checkTodayIsInDateRange(Date previousDate, Date nextDate) throws ParseException {
        Date today = getDateWithoutTime(new Date());
        return !(today.before(previousDate) || today.after(nextDate));
    }
    
    public static boolean checkDateIsInDateRange(Date previousDate, Date nextDate, Date checkDate)
            throws ParseException {
        Date date = getDateWithoutTime(checkDate);
        return !(date.before(previousDate) || date.after(nextDate));
    }
    
    public static String formatDate(String previousFormat, String newFormat, String dateToFormat)
            throws ParseException {
        SimpleDateFormat rawFmt = new SimpleDateFormat(previousFormat);
        SimpleDateFormat newFrmt = new SimpleDateFormat(newFormat);
        Date date = rawFmt.parse(dateToFormat);
        return newFrmt.format(date);

    }
    
    public static long getTimeStampFromString(String format, String dateToFormat) throws ParseException {
        SimpleDateFormat rawFmt = new SimpleDateFormat(format);
        return rawFmt.parse(dateToFormat).getTime();
    }
    
    public static XMLGregorianCalendar getXMLGregorianDateFromString(String date)
            throws DatatypeConfigurationException {
        XMLGregorianCalendar fromDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(date);
        fromDate.setTimezone(DatatypeConstants.FIELD_UNDEFINED);
        return fromDate;
    }
    
}
