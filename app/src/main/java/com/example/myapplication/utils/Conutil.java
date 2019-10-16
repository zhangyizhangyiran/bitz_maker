package com.example.myapplication.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Conutil {


    public static String timedate(String time) {
        SimpleDateFormat sdr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long lcc = Long.valueOf(time);
        int i = Integer.parseInt(time);
//        String times = sdr.format(new Date(i * 1000L));
        String times = sdr.format(new Date(i * 1000L));
        return times;

    }
}
