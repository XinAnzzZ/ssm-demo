package com.alibaba.xinan.common.util;

import java.security.MessageDigest;

/**
 * @author XinAnzzZ
 * @date 2018/8/14 20:00
 */
@SuppressWarnings("unused")
public class EncryptUtils {

    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5',
            '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /**
     * Takes the raw bytes from the digest and formats them correct.
     *
     * @param bytes the raw bytes from the digest.
     * @return the formatted bytes.
     */
    private static String getFormattedText(byte[] bytes) {
        int len = bytes.length;
        StringBuilder buf = new StringBuilder(len * 2);
        // 把密文转换成十六进制的字符串形式
        for (byte item : bytes) {
            buf.append(HEX_DIGITS[(item >> 4) & 0x0f]);
            buf.append(HEX_DIGITS[item & 0x0f]);
        }
        return buf.toString();
    }

    /**
     * 一次 MD5 加密
     *
     * @param str 要加密的字符串
     * @return 加密后的结果
     */
    public static String encodeToMD5(String str) {
        if (str == null) {
            return null;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("md5");
            messageDigest.update(str.getBytes());
            return getFormattedText(messageDigest.digest());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
