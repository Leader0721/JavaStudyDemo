package day08Request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * 获取请求消息头
 * Created by 83731 on 2017/08/17.
 */
@WebServlet(name = "ServletRequest02")
public class ServletRequest02 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }


    //http协议允许头有重置的情况，多个重名的头
    private void test01(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Enumeration<String> e = request.getHeaders("Accept-Encoding");
        //得到多个头值   头名就有一个  是获取到了多个值


        while (e.hasMoreElements()) {
            String headName = e.nextElement();
            System.out.println(headName + "=" + request.getHeader(headName));
            System.out.println(headName);
        }
    }

    //得到所有的消息头
    private void test02(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Enumeration<String> list = request.getHeaderNames();
        while (list.hasMoreElements()) {
            String headName = list.nextElement();//头名称
            Enumeration<String> headList = request.getHeaders(headName);
            while (headList.hasMoreElements()) {
                System.out.println(headName + ":" + headList.nextElement());
            }
        }
    }


    //得到指定请求消息头的值  如果没有该头   返回 null
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String supportEncoding = request.getHeader("Accept-Encoding");
//        System.out.println(supportEncoding);   //会获取到 gzip  deflate
//        if (supportEncoding.contains("gzip")) {
//            System.out.println("支持gzip压缩");
//        } else {
//            System.out.println("不支持gzip压缩");
//        }

        test02(request, response);
    }
}
