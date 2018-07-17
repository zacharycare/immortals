package com.zacharyz.common.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * 时间相关工具类
 */
public class TimeUtil {

    public static final String formatYMD = "yyyy-MM-dd";

    /**
     * 获取当前时间
     * @return String
     */
    public static String getNow(){
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat(formatYMD);
        return format.format(calendar.getTime());
    }

    public static void main(String[] args) {
        System.out.println(getNow());
    }
}
