package com.du.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.MessageDigest;

/**
 *  Md5加密方法
 */
public class Md5Utils {

    private static final Logger logger = LoggerFactory.getLogger(Md5Utils.class);

    private static byte[] md5(String s){
        MessageDigest messageDigest;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(s.getBytes("UTF-8"));
            byte[] newMessageDigest = messageDigest.digest();
            return newMessageDigest;
        }catch (Exception e){
            logger.error("MD% Error...",e);
        }
        return null;
    }

    private static final String toHex(byte hash[]){
        if (hash ==null){
            return null;
        }
        StringBuilder buf= new StringBuilder(hash.length*2);
        int i;
        for ( i = 0; i <hash.length ; i++) {
            if ((hash[i] & 0xff) < 0x10){
                buf.append("0");
            }
            buf.append(Long.toString(hash[i] & 0xff,16));
        }
        return buf.toString();
    }

    public static String hash(String s){
        try {
            return new String(toHex(md5(s)).getBytes("UTF-8"),"UTF-8");
        }catch (Exception e){
            logger.error("not supported charset...{}",e);
            return s;
        }
    }
}
