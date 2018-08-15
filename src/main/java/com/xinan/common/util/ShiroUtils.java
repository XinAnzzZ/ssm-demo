package com.xinan.common.util;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * @author XinAnzzZ
 * @date 2018/8/15 10:20
 */
public class ShiroUtils {

    /**
     * shiro 的MD5加密，通过用户的密码和用户名作为盐进行1024次加密
     *
     * @param credentials 凭证（密码）
     * @param salt        盐（用户名）
     * @return 加密后的结果
     */
    public static String toMD5(String credentials, String salt) {
        String hashAlgorithmName = "md5";
        int hashIterations = 1024;
        return new SimpleHash(hashAlgorithmName, credentials, ByteSource.Util.bytes(salt), hashIterations).toString();
    }
}
