package com.stripcode.core.util;

import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * User: Metro
 * Date: 12-8-23
 * Time: 下午3:51
 * To change this template use File | Settings | File Templates.
 */
public class Tools {

    public static String getClassPath(){
        String classPath = Tools.class.getClassLoader().getResource("/").getPath();

        //windows下
        if("\\".equals(File.separator)){

            classPath = classPath.replace("/", "\\");
        }
        //linux下
        if("/".equals(File.separator)){

            classPath = classPath.replace("\\", "/");
        }
        return classPath;
    }

    public static String getRootPath(){
        String classPath = Tools.getClassPath();
        String rootPath = classPath.substring(0, classPath.indexOf("WEB-INF"));
        return rootPath;
    }

}
