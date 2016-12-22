package com.stripcode.core.util;

import java.util.UUID;

/**
 * Created by Metro on 2016/8/19.
 */
public class UUIDUtils {
    public static String generateKey(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }
}
