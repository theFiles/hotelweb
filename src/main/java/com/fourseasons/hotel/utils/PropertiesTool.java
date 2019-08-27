package com.fourseasons.hotel.utils;

import java.util.ResourceBundle;

/**
 * 配置工具类
 * @author lidaye
 */
public class PropertiesTool {
    /**
     * 获取一个配置值
     * @param name      配置文件名
     * @param key       配置参数名
     * @return          配置值字符串
     */
    public static String param(String name,String key){
        ResourceBundle tokenConfig = ResourceBundle.getBundle(name);
        return tokenConfig.getString(key);
    }

    /**
     * 获取多个配置值
     * @param name      配置文件名
     * @param key       配置参数名（多个）
     * @return          配置值数组
     */
    public static String[] param(String name,String... key){
        ResourceBundle tokenConfig = ResourceBundle.getBundle(name);
        int len = key.length;
        for (int i = 0; i < len; i++) {
            key[i] = tokenConfig.getString(key[i]);
        }
        return key;
    }
}
