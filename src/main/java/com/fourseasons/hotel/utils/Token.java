package com.fourseasons.hotel.utils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Token {
    public static String enToken(Integer id,Long key){
        String token = "";
        try {
            token = AES.encrypt(id.toString(),key.toString());
            System.out.println(key.toString());
        } catch (Exception e) {
            log.debug(e.getMessage());
        }

        return token;
    }

    public static String deToken(String token,Long key){
        String content = "";
        try {
            content = AES.decrypt(token,key.toString());
        } catch (Exception e) {
            log.debug(e.getMessage());
        }

        return content;
    }

}
