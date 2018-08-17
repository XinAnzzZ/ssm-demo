package com.xinan.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author XinAnzzZ
 * @date 2018/8/15 14:38
 */
@SuppressWarnings("unused")
public class PropertyUtils {

    private static final Logger logger = LoggerFactory.getLogger(PropertyUtils.class);

    private static Properties props;

    static {
        loadProps();
    }

    private static synchronized void loadProps() {
        logger.debug("开始加载properties文件内容.......");
        props = new Properties();
        InputStream inputStream = null;
        try {
            // 第一种，通过类加载器进行获取properties文件流
            inputStream = PropertyUtils.class.getClassLoader().getResourceAsStream("global.properties");
            props.load(inputStream);
        } catch (FileNotFoundException e) {
            logger.error("global.properties文件未找到");
        } catch (IOException e) {
            logger.error("出现IOException");
        } finally {
            try {
                if (null != inputStream) {
                    inputStream.close();
                }
            } catch (IOException e) {
                logger.error("global.properties文件流关闭出现异常");
            }
        }
        logger.info("加载properties文件内容完成...........");
        logger.info("properties文件内容：" + props);
    }

    public static String getProperty(String key) {
        if (null == props) {
            loadProps();
        }
        return props.getProperty(key);
    }

    public static String getProperty(String key, String defaultValue) {
        if (null == props) {
            loadProps();
        }
        return props.getProperty(key, defaultValue);
    }
}
