package com.zy.gis.common.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateUtil {

    public static ThreadLocal<DateFormat> threadLocal = new ThreadLocal<DateFormat>(){
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
    };

    public static Date parse(String dateStr) throws ParseException {
        return threadLocal.get().parse(dateStr);
    }
    /**
    @author Wangchong
    @date 2021/10/29 16:03
    @description TODO long型转日期字符串
    @param time 毫秒数
    @return  日期字符串
    */
    public static String parseTimeLong(Long time){
        return threadLocal.get().format(new Date(time));
    }
    /**
     * 获取当前时间
     * yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static String getNowTime() {
        return threadLocal.get().format(new Date());
    }
    /**
     * 获取30天前的时间
     *
     */
    public static String getTimeBeforeThirty(){
        Calendar now = Calendar.getInstance();
        now.add(Calendar.DAY_OF_MONTH, -30);
        String endDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(now.getTime());
        return endDate;
    }
    /**
     * 获取当前日期
     * yyyy-MM-dd
     * @return
     */
    public static String getNowDate(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return simpleDateFormat.format(System.currentTimeMillis());
    }
    /**
     * 获取30天前的日期
     *
     */
    public static String getDateBeforeThirty(){
        Calendar now = Calendar.getInstance();
        now.add(Calendar.DAY_OF_MONTH, -30);
        String endDate = new SimpleDateFormat("yyyy-MM-dd").format(now.getTime());
        return endDate;
    }
    /**
     * 获取n天前的日期
     *
     */
    public static String getDateBefore(int days){
        Calendar now = Calendar.getInstance();
        now.add(Calendar.DAY_OF_MONTH, -days);
        String endDate = new SimpleDateFormat("yyyy-MM-dd").format(now.getTime());
        return endDate;
    }
    /**
     * 是否是英文
     * @param charaString
     * @return
     */
    public static boolean isEnglish(String charaString){

        return charaString.matches("^[a-zA-Z]*");

    }

    public static boolean isChinese(String str){

        String regEx = "[\\u4e00-\\u9fa5]+";

        Pattern p = Pattern.compile(regEx);

        Matcher m = p.matcher(str);

        if(m.find())

            return true;

        else

            return false;

    }
}
