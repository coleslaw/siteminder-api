package com.noetic.api.siteminder.util;

import com.noetic.exception.InvalidInputExceptionJson;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Prageeth Sudesh on 09/11/2018.
 */
public class SiteminderUtil {

    private static Logger log = LoggerFactory.getLogger(SiteminderUtil.class);

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


    public static String convertStreamToString(InputStream is) throws InvalidInputExceptionJson {

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
    
    public static boolean isPastDate(String date) throws ParseException {
        DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyyMMdd");
        DateTime dt = formatter.parseDateTime(date);
        //check the given date is before today
        return dt.isBefore(getDateWithoutTime(new Date()).getTime());
    }
    
    public static Date getDateWithoutTime(Date day) throws ParseException {
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        return formatter.parse(formatter.format(day));
    }

}
