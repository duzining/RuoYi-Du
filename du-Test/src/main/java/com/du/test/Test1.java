package com.du.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test1 {

    public static void main(String[] args) {
        /*ThreadLocal threadLocal = new ThreadLocal();
        String a = "asa@@adad";
        System.out.println(a.indexOf("@@"));
        if (a.indexOf("@@")!=-1){
            System.out.println(a);
            String [] b = a.split("@@");
            for (String s : b) {
                System.out.println(s);
            }
        }*/

        Map<String,Object> map = new HashMap<>();
        if(map.get("kd")!=null){
            System.out.println("aa");
        }
    }
}
