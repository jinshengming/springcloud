package com.jsm.common.util.date;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static org.apache.commons.lang3.time.DateUtils.*;

/**
 * 日期工具类
 * @author jinshengming
 * @date 2021/5/8 15:52
 */
public class DateUtils {

    private static final Log logger = LogFactory.getLog(DateUtils.class);

    public static final String DATE_SHORT_FORMAT = "yyyyMMdd";
    public static final String DATE_CH_FORMAT = "yyyy年MM月dd日";

    public static final String DATE_SORT_TIME_FORMAT = "yyyyMMddHHmmss";
    public static final String DATE_TIME_FORMAT_HHMM = "yyyy-MM-dd HH:mm";
    public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String TIMESTAMP_FORMAT = "yyyy-MM-dd HH:mm:ss.S";
    public static final String DATE_FORMAT = "yyyy-MM-dd";
    public static final String DATE_MONTH_FORMAT = "yyyy-MM";
    public static final String TIME_FORMAT = "HH:mm:ss";

    public static final String YYYY = "yyyy";
    public static final String MM = "MM";
    public static final String DD = "dd";

    public static final String DAYTIME_START = "00:00:00";
    public static final String DAYTIME_END = "23:59:59";

    private static final String[] FORMATS = {"yyyy-MM-dd", "yyyy-MM-dd HH:mm",
            "yyyy-MM-dd HH:mm:ss", "HH:mm", "HH:mm:ss", "yyyy-MM",
            "yyyy-MM-dd HH:mm:ss.S"};

    public static final String FIRST_DAY = "firstDay", LAST_DAY = "lastDay";

    private DateUtils() {

    }

    /**
     * 字符串转换成日期 主要解决json传入日期问题
     */
    public static Date convert(String str) {
        if (StringUtils.isNotBlank(str)) {
            if (str.length() > 10 && str.charAt(10) == 'T') {
                // 去掉json-lib加的T字母
                str = str.replace('T', ' ');
            }
            for (String format : FORMATS) {
                if (format.length() == str.length()) {
                    try {
                        return new SimpleDateFormat(format).parse(str);
                    } catch (ParseException e) {
                        if (logger.isWarnEnabled()) {
                            logger.warn(e.getMessage());
                        }
                    }
                }
            }
        }
        return null;
    }

    /**
     * 字符串、日期格式 转换日期
     * @param format 例如: "yyyy-MM-dd HH:mm:ss"
     * @param str 例如: "2012-12-03 23:21:24"
     */
    public static Date convert(String str, String format) {
        if (!StringUtils.isEmpty(str)) {
            try {
                return new SimpleDateFormat(format).parse(str);
            } catch (ParseException e) {
                if (logger.isWarnEnabled()) {
                    logger.warn(e.getMessage());
                }
            }
        }
        return null;
    }

    /**
     * 将日期转换成format字符串
     * @param date 例如: Sun Jun 10 09:18:00 CST 2018
     * @param dateFormat 例如: "yyyy-MM-dd HH:mm:ss"
     */
    public static String convert(Date date, String dateFormat) {
        if (date == null) {
            return null;
        }
        if (null == dateFormat) {
            dateFormat = DATE_TIME_FORMAT;
        }
        return new SimpleDateFormat(dateFormat).format(date);
    }

    /**
     * 根据传入的日期  转换成这样格式的字符串 如：“yyyy-MM-dd HH:mm:ss”
     */
    public static String convert(Date date) {
        return convert(date, DATE_TIME_FORMAT);
    }

    /**
     * 时间拼接 将日期和实现拼接 ymd 如2012-05-15 hm 如0812 最终 2012-05-15 08:12:00
     */
    public static Date concat(String ymd, String hm) {
        if (!StringUtils.isBlank(ymd) && !StringUtils.isBlank(hm)) {
            try {
                String dateString = ymd.concat(" ").concat(hm.substring(0, 2)).concat(":").concat(hm.substring(2, 4)).concat(":00");
                return convert(dateString, DateUtils.DATE_TIME_FORMAT);
            } catch (NullPointerException e) {
                if (logger.isWarnEnabled()) {
                    logger.warn(e.getMessage());
                }
            }
        }
        return null;
    }

    /**
     * 根据传入的日期返回年月日的6位字符串，例：20101203
     */
    public static String getDay(Date date) {
        return convert(date, DATE_SHORT_FORMAT);
    }

    /**
     * 根据传入的日期返回中文年月日字符串，例：2010年12月03日
     */
    public static String getChDate(Date date) {
        return convert(date, DATE_CH_FORMAT);
    }

    /**
     * 返回该天从00:00:00开始的日期
     */
    public static Date getStartDatetime(Date date) {
        String thisDate = convert(date, DATE_FORMAT);
        return convert(thisDate + " " + DAYTIME_START);
    }

    /**
     * 返回该天到23:59:59结束的日期
     */
    public static Date getEndDatetime(Date date) {
        String thisDate = convert(date, DATE_FORMAT);
        return convert(thisDate + " " + DAYTIME_END);
    }

    /**
     * 返回n天到23:59:59结束的日期
     */
    public static Date getEndDatetime(Date date, Integer diffDays) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
        String thisDate = dateFormat.format(date.getTime() + MILLIS_PER_DAY * diffDays);
        return convert(thisDate + " " + DAYTIME_END);
    }


    /**
     * 将传入的时间格式的字符串转成时间对象      例如：传入2012-12-03 23:21:24
     */
    public static Date strToDate(String dateStr) {
        SimpleDateFormat formatDate = new SimpleDateFormat(DATE_TIME_FORMAT);
        Date date = null;
        try {
            date = formatDate.parse(dateStr);
        } catch (Exception ignored) {

        }
        return date;
    }

    /**
     * 返回该日期的最后一刻，精确到纳秒
     */
    public static Timestamp getLastEndDatetime(Date endTime) {
        Timestamp ts = new Timestamp(endTime.getTime());
        ts.setNanos(999999999);
        return ts;
    }

    /**
     * 返回该日期加1秒
     */
    public static Timestamp getEndTimeAdd(Date endTime) {
        Timestamp ts = new Timestamp(endTime.getTime());
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(ts);
        calendar.add(Calendar.MILLISECOND, 1000);
        calendar.set(Calendar.MILLISECOND, 0);
        return new Timestamp(calendar.getTimeInMillis());
    }

    /**
     * 返回该日期加 millisecond 毫秒，正数为加，负数为减
     */
    public static Timestamp getDateAdd(Date date, int millisecond) {
        Timestamp ts = new Timestamp(date.getTime());
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(ts);
        calendar.add(Calendar.MILLISECOND, millisecond);
        calendar.set(Calendar.MILLISECOND, 0);
        return new Timestamp(calendar.getTimeInMillis());
    }

    /**
     * 相对当前日期，增加或减少天数
     */
    public static String addDay(Date date, int day) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_FORMAT);
        return simpleDateFormat.format(new Date(date.getTime() + MILLIS_PER_DAY * day));
    }

    /**
     * 相对当前日期，增加或减少天数
     */
    public static Date addDayToDate(Date date, int day) {
        return new Date(date.getTime() + MILLIS_PER_DAY * day);
    }

    public static Long getTimeDiff(String startTime, String endTime) {
        int months = 0;
        Long days;
        Date startDate, endDate;
        try {
            if (startTime.length() == 10 && endTime.length() == 10) {
                startDate = new SimpleDateFormat(DATE_FORMAT).parse(startTime);
                endDate = new SimpleDateFormat(DATE_FORMAT).parse(endTime);
                days = getTimeDiff(startDate, endDate);
            } else if (startTime.length() == 7 && endTime.length() == 7) {
                startDate = new SimpleDateFormat(DATE_MONTH_FORMAT).parse(startTime);
                endDate = new SimpleDateFormat(DATE_MONTH_FORMAT).parse(endTime);
                months = getMonthDiff(startDate, endDate);
                days = (long) months;
            } else {
                startDate = new SimpleDateFormat(DATE_TIME_FORMAT).parse(startTime);
                endDate = new SimpleDateFormat(DATE_TIME_FORMAT).parse(endTime);
                days = getTimeDiff(startDate, endDate);
            }
        } catch (ParseException e) {
            if (logger.isWarnEnabled()) {
                logger.warn(e.getMessage());
            }
            days = null;
        }
        return days;
    }

    /**
     * 返回两个时间的相差天数
     */
    public static Long getTimeDiff(Date startTime, Date endTime) {
        Calendar c = Calendar.getInstance();
        c.setTime(startTime);
        long l_s = c.getTimeInMillis();
        c.setTime(endTime);
        long l_e = c.getTimeInMillis();
        return (l_e - l_s) / MILLIS_PER_DAY;
    }

    /**
     * 返回两个时间的相差天数
     */
    public static int getDateDiff(Date startTime, Date endTime) {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(startTime);

        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(endTime);
        int day1= cal1.get(Calendar.DAY_OF_YEAR);
        int day2 = cal2.get(Calendar.DAY_OF_YEAR);

        int year1 = cal1.get(Calendar.YEAR);
        int year2 = cal2.get(Calendar.YEAR);
        if(year1 != year2)   //同一年
        {
            int timeDistance = 0 ;
            for(int i = year1 ; i < year2 ; i ++)
            {
                if(i%4==0 && i%100!=0 || i%400==0)    //闰年
                {
                    timeDistance += 366;
                }
                else    //不是闰年
                {
                    timeDistance += 365;
                }
            }

            return timeDistance + (day2-day1) ;
        }
        else    //不同年
        {
            return day2-day1;
        }
    }

    /**
     * 返回两个时间的相差分钟数
     */
    public static Long getMinuteDiff(Date startTime, Date endTime) {
        Calendar c = Calendar.getInstance();
        c.setTime(startTime);
        long l_s = c.getTimeInMillis();
        c.setTime(endTime);
        long l_e = c.getTimeInMillis();
        return (l_e - l_s) / MILLIS_PER_MINUTE;
    }

    /**
     * 返回两个时间的相差秒数
     */
    public static Long getSecondDiff(Date startTime, Date endTime) {
        return (endTime.getTime() - startTime.getTime()) / MILLIS_PER_SECOND;
    }

    /**
     * 返回两个时间的相差月数
     */
    public static int getMonthDiff(Date startTime, Date endTime) {
        int months = 0;

        Calendar startCalendar = Calendar.getInstance();
        Calendar endCalendar = Calendar.getInstance();
        startCalendar.setTime(startTime);
        endCalendar.setTime(endTime);
        months = endCalendar.get(Calendar.MONTH) - startCalendar.get(Calendar.MONTH);
        return months;
    }


    /**
     * 返回日期所在月份第一天和最后一天
     *
     * @param date 指定的日期
     * @param mon  月份计算， 0-当月，-1-上月，1-下月，以此类推
     * @return Map<String, String>
     */
    public static Map<String, String> getSpecifiedMonthFirstAndLastDay(Date date, int mon) {
        Map<String, String> map = new HashMap<>();
        SimpleDateFormat df = new SimpleDateFormat(DATE_FORMAT);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, mon);
        Date theDate = calendar.getTime();
        // 上个月第一天
        GregorianCalendar gcLast = (GregorianCalendar) Calendar.getInstance();
        gcLast.setTime(theDate);
        gcLast.set(Calendar.DAY_OF_MONTH, 1);
        String daFirst = df.format(gcLast.getTime());
        // 上个月最后一天
        // 加一个月
        calendar.add(Calendar.MONTH, 1);
        // 设置为该月第一天
        calendar.set(Calendar.DATE, 1);
        // 再减一天即为上个月最后一天
        calendar.add(Calendar.DATE, -1);
        String dayLast = df.format(calendar.getTime());
        String str1 = daFirst + " " + DAYTIME_START;
        String str2 = dayLast + " " + DAYTIME_END;
        map.put(FIRST_DAY, str1);
        map.put(LAST_DAY, str2);
        return map;
    }


}