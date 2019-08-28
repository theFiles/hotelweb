package com.fourseasons.hotel.utils;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;

public class Base64Tool {
    private static BASE64Encoder base64Encoder;
    private static BASE64Decoder base64Decoder;

    static{
        base64Encoder = new BASE64Encoder();
        base64Decoder = new BASE64Decoder();
    }

    public static String encode(byte[] bytes){
        return base64Encoder.encode(bytes);
    }

    public static String encode(String str){
        return encode(str.getBytes());
    }


    public static String decode(String str){
        return new String(decodeToByte(str));
    }

    public static byte[] decodeToByte(String str){
        byte[] bytes = null;
        try {
            bytes = base64Decoder.decodeBuffer(str);
        } catch (IOException e) {
//            e.printStackTrace();
        }
        return bytes;
    }
}
