package com.xinan.common.util;

import java.util.UUID;

/**
 * @author XinAnzzZ
 * @date 2018/8/14 19:55
 */
@SuppressWarnings("unused")
public class CommonUtils {

    public static String generateUUID() {
        return UUID.randomUUID().toString();
    }
}
