package day19_01_autologin.util;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by 83731 on 2017/11/05.
 */
public class SecurityUtil {
    public static String md5(String s) {
        String s1 = "";
        try {
            MessageDigest messageDigest = null;
            messageDigest = MessageDigest.getInstance("md5");

            byte b[] = messageDigest.digest(s.getBytes());//用md5算法得到s这段数据的摘要
            BASE64Encoder base64Encoder = new BASE64Encoder();
            s1 = base64Encoder.encode(b);

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

        return s1;
    }

    public static String base64encode(String s){
        BASE64Encoder base64Encoder = new BASE64Encoder();
        return base64Encoder.encode(s.getBytes());
    }

    public static String base64decode(String s) {
        BASE64Decoder base64Decoder = new BASE64Decoder();

        try {
            return new String(base64Decoder.decodeBuffer(s));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }


}
