package com.alorma.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by alorma on 6/29/13.
 */
public class DateUtils {

    public static String parseUTC(String utcTime) {
        String cleanDate = utcTime.replace("-", "/");
        cleanDate = cleanDate.replaceAll("T", " - ");
        cleanDate = cleanDate.replaceAll("Z", "");

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd - hh:mm:ss");
            Date date = sdf.parse(cleanDate);
            sdf = new SimpleDateFormat("hh:mm - dd/MM/yyyy");

            return sdf.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return cleanDate;
    }
}
