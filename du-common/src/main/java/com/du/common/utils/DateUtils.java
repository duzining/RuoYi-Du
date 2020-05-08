package com.du.common.utils;

import org.apache.commons.lang3.time.DateFormatUtils;

import java.text.ParseException;
import java.util.Date;

/**
 * 时间工具类
 */
public class DateUtils extends org.apache.commons.lang3.time.DateUtils {

    public static String YYYY = "yyyy";

    public static String YYYY_MM = "yyyy-MM";

    public static String YYYY_MM_DD = "yyyy-MM-dd";

    public static String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";

    public static String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

    private static String[] parsePatterns = {
            "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy-MM",
            "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm", "yyyy/MM",
            "yyyy.MM.dd", "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm", "yyyy.MM"};

    /**
     * 日期型字符串转化为日期 格式
     */
    public static Date parseDate(Object str){
        if (str == null){
            return null;
        }
        try {
            return parseDate(str.toString(),parsePatterns);
        }catch (ParseException e){
            return null;
        }
    }

    /**
     * 日期路径 即年/月/日 如2018/08/08
     */
    public static final String datePath(){
        Date now = new Date();
        return DateFormatUtils.format(now,"yyyy/MM/dd");
    }

}
