package com.stripcode.core.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Metro on 15-12-3.
 */
public class DataTimeUtils {

    public static String getCurrentTime(){
        Date currentTime = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(currentTime);
    }
}
