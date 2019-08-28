package com.fourseasons.hotel.utils;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Arrays;

public class AES {
    private static int KEY_LENGTH = 16;

    public static String encrypt(String sSrc, String sKey) throws Exception {
        if (sKey == null) {
            System.out.print("Key为空null");
            return null;
        }
        // 判断Key是否为16位
        if (sKey.length() != KEY_LENGTH) {
            sKey = resetKey(sKey);
        }
        byte[] raw = sKey.getBytes("utf-8");
        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
        //"算法/模式/补码方式"
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
        byte[] encrypted = cipher.doFinal(sSrc.getBytes("utf-8"));
        //此处使用BASE64做转码功能，同时能起到2次加密的作用。
        return Base64Tool.encode(encrypted);
    }

    public static String decrypt(String sSrc, String sKey) throws Exception {
        try {
            // 判断Key是否正确
            if (sKey == null) {
                System.out.print("Key为空null");
                return null;
            }
            // 判断Key是否为16位
            if (sKey.length() != KEY_LENGTH) {
                sKey = resetKey(sKey);
            }
            byte[] raw = sKey.getBytes("utf-8");
            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, skeySpec);
            //先用base64解密
            byte[] encrypted1 = Base64Tool.decodeToByte(sSrc);
            try {
                byte[] original = cipher.doFinal(encrypted1);
                String originalString = new String(original,"utf-8");
                return originalString;
            } catch (Exception e) {
                System.out.println(e.toString());
                return null;
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return null;
        }
    }

    /**
     * 补位和消位逻辑
     * @param key       秘钥
     * @return          16位长度的字符
     */
    private static String resetKey(String key){
        String newKey;
        int len = key.length();
        // 多于16位
        if(len > KEY_LENGTH){
            newKey = key.substring(len-KEY_LENGTH);
        }
        // 小于16位
        else{
            char[] tmpArr = new char[KEY_LENGTH-len];
            Arrays.fill(tmpArr,'0');
            newKey = key + new String(tmpArr);
        }

        return newKey;
    }
}
