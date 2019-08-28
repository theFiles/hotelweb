package com.fourseasons.hotel.utils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Token {
    public static String enToken(Integer id,Long key){
        String token = "";
        try {
            token = AES.encrypt(id.toString(),tokenKey(key));
        } catch (Exception e) {
            log.debug(e.getMessage());
        }

        return Base64Tool.encode(token);
    }

    public static String deToken(String token,Long key){
        String content = "";
        try {
            content = AES.decrypt(Base64Tool.decode(token),tokenKey(key));
        } catch (Exception e) {
            log.debug(e.getMessage());
        }

        return content;
    }

    private static String tokenKey(Long key){
        String keyStr = key.toString();
        return keyStr.substring(0,keyStr.length()-3);
    }

}
