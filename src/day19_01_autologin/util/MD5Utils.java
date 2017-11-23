package day19_01_autologin.util;

import sun.misc.BASE64Encoder;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * Created by 83731 on 2017/11/05.
 */
public class MD5Utils {
    public static void main(String[] args) throws Exception {
        String s = "123456";
        MessageDigest messageDigest = MessageDigest.getInstance("md5");
        byte b[] = messageDigest.digest(s.getBytes());//用md5算法得到s这段数据的摘要
        //这段摘要在任何码表中有可能都没有对应的字符


        //把二进制转换成可见字符:Base64
        /**
         Base64编码原理：3字节---》4字节
         1010 0101 0011 1001 1111 1011
         00101001  00010011   00100111   00111011
         每个字节表示的范围: 00000000--00111111整数 :0--63共64个整数
         而这64个整数分别对应着键盘上的可见字符:base64是一个可见的码表
         */


        BASE64Encoder base64Encoder = new BASE64Encoder();
        String s1 = base64Encoder.encode(b);
        System.out.println(s1);


    }
}
