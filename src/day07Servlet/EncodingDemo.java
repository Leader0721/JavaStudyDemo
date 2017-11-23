package day07Servlet;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;


/**
 * Created by 83731 on 2017/08/15.
 */
public class EncodingDemo {
    @Test
    public void test1(){
        String s = "任统帅";
        try {
            System.out.println(URLEncoder.encode(s,"UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void test2(){
        String s = "%E4%BB%BB%E7%BB%9F%E5%B8%85";
        try {
            System.out.println(URLDecoder.decode(s,"UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

}
