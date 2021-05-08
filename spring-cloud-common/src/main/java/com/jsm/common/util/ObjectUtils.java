package com.jsm.common.util;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

/**
 * @author 金生明
 */
public final class ObjectUtils {


    private ObjectUtils() {
        throw new IllegalStateException("Illegal operation");
    }



    /**
     * 判断字符串是否为“null”或者为“undefined”
     * @param param param
     * @return  boolean
     */
    public static boolean isNull(Object param) {

        if (param == null) {
            return true;
        }

        if (param instanceof String) {

            String s = param.toString();

            if ("null".equals(s) || "undefined".equals(s)) {
                return true;
            }
            return StringUtils.isBlank(s);
        }

        if (param instanceof Collection) {
            Collection<?> collection = (Collection<?>) param;
            if (CollectionUtils.isEmpty(collection)) {
                return true;
            }
            for (Object o : collection) {
                if (o != null) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    /**
     * 判断字符串是否为“null”或者为“undefined”
     *
     * @param param param
     * @return boolean
     */
    public static boolean nonNull(Object param) {
        return !isNull(param);
    }

    /**
     * 判断字符串是否以某某开头
     * 当你需要使用
     *
     * @param str    .
     * @param prefix .
     * @return {boolean}
     * @author jinshengming
     * @date 2021/1/19 10:48
     */
    public static boolean startsWith(String str, String prefix) {
        if (StringUtils.isBlank(str)) {
            return false;
        }
        return str.startsWith(prefix);
    }

    /**
     * 判断字符串是否包含参数二
     * 当你需要使用
     *
     * @param str .
     * @param s   .
     * @return {boolean}
     * @author jinshengming
     * @date 2021/1/19 10:48
     */
    public static boolean contains(String str, String s) {
        if (StringUtils.isBlank(str)) {
            return false;
        }
        return str.contains(s);
    }

    /**
     * 校验类里的属性是不是全是null或者”“ -> 只针对字符串类型
     * 如果类里的属性全部是null或者""，则返回true
     *
     * @param param        .
     * @param excludeField . 不参与校验的属性
     * @return boolean
     * @author 金生明
     * @date 2020/7/30 14:00
     **/
    public static boolean allPropertyIsNull(Object param, String... excludeField) {
        if (param == null) {
            throw new IllegalArgumentException("param must have value.");
        }
        Class<?> clazz = param.getClass();

        Method[] methods = clazz.getDeclaredMethods();
        Field[] fields = clazz.getDeclaredFields();
        if (methods.length == 0 || fields.length == 0) {
            return true;
        }
        try {
            for (Method method : methods) {
                Class<?> type = method.getReturnType();
                String name = method.getName();
                if (!method.getName().startsWith("get")) {
                    continue;
                }
                long count = Arrays.stream(fields).filter(field -> name.toLowerCase().contains(field.getName().toLowerCase())).distinct().count();
                if (count == 0) {
                    continue;
                }
                if (!checkExcludeField(name, excludeField)) {
                    Object invoke = method.invoke(param);
                    if (type == String.class) {
                        if (invoke != null && StringUtils.isNotBlank(invoke.toString())) {
                            return false;
                        }
                    } else if (type == List.class) {
                        if (CollectionUtils.isNotEmpty((List<?>) invoke)) {
                            return false;
                        }
                    } else {
                        if (invoke != null) {
                            return false;
                        }
                    }
                }
            }
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return true;
    }

    /**
     * 判断两个对象是否相等
     *
     * @param param1 .
     * @param param2 .
     * @return boolean
     * @author 金生明
     * @date 2020/10/19 16:11
     **/
    public static boolean equals(Object param1, Object param2) {
        if (param1 == param2) {
            return true;
        }
        if (param1 == null || param2 == null) {
            return false;
        }
        if (param1 instanceof BigDecimal && param2 instanceof BigDecimal) {
            BigDecimal b1 = (BigDecimal) param1;
            BigDecimal b2 = (BigDecimal) param2;
            return b1.compareTo(b2) == 0;
        }
        return Objects.equals(param1, param2);
    }

    /**
     * 排除字段
     *
     * @param name         .
     * @param excludeField .
     * @return boolean
     * @author 金生明
     * @date 2020/8/29 12:02
     **/
    private static boolean checkExcludeField(String name, String... excludeField) {
        if (excludeField != null && excludeField.length > 0) {
            for (String s : excludeField) {
                String get = name.substring(name.indexOf("get") + 3);
                if (get.toLowerCase().equals(s.toLowerCase())) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 检查所有字段是否均为空
     *
     * @param param .
     * @return {@link boolean}
     * @author jinshengming
     * @date 2020/12/22 16:06
     */
    public static boolean isAllBlank(String... param) {
        if (ArrayUtils.isEmpty(param)) {
            return true;
        }
        for (String s : param) {
            if (StringUtils.isNotBlank(s)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 检查所有字段是否均不为空
     *
     * @param param .
     * @return {@link boolean}
     * @author jinshengming
     * @date 2020/12/22 16:06
     */
    public static boolean isAllNotBlank(String... param) {
        if (ArrayUtils.isEmpty(param)) {
            return false;
        }
        for (String s : param) {
            if (StringUtils.isBlank(s)) {
                return false;
            }
        }
        return true;
    }

}
