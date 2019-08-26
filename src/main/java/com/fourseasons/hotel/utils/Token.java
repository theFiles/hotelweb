package com.fourseasons.hotel.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Token {
    public static String enToken(Integer id,long key){
        return id+"&"+key;
    }

    public static String deToken(String token){
        return token.substring(0,token.charAt('&'));
    }
}
