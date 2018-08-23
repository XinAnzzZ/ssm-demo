package com.xinan.common.util;

/**
 * @author XinAnzzZ
 * @date 2018/8/23 13:15
 */
@SuppressWarnings("unused")
public class StringUtils {

    /**
     * 判断 string 是否为 null 或者为 ""
     *
     * @param strings the string
     * @return is empty
     */
    public static boolean isEmpty(String... strings) {
        for (String string : strings) {
            if (string == null || "".equals(string)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isNotEmpty(String... strings) {
        return !isEmpty(strings);
    }

    /**
     * 判断 string 是否为 null 或者为 "" 或者为 "   "
     *
     * @param strings the string
     * @return result
     */
    public static boolean isBlank(String... strings) {
        for (String string : strings) {
            if (string == null || "".equals(string.trim())) {
                return true;
            }
        }
        return false;
    }

    public static boolean isNotBlank(String... strings) {
        return !isBlank(strings);
    }
}
