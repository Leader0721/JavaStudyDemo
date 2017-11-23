package day08Request;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;


/**
 * 以输入流的形式接受请求正文:只是用与 POST方式
 * <p>
 * 一般情况下用不着，文件上传的时候进行使用
 * <p>
 * Created by 83731 on 2017/08/20.
 */
@WebServlet(name = "ServletRequest04")
public class ServletRequest04 extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        test3(request,response);
    }
    //请求编码和响应编码没有关系
    private void test3(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");//设置请求正文的编码。只对POST有效
        Student s = new Student();
        System.out.println("封装前："+s);
        try {
            BeanUtils.populate(s, request.getParameterMap());
        } catch (Exception e) {
            e.printStackTrace();
        }

        response.setContentType("text/html;charset=UTF-8");

        response.getWriter().write(s.toString());
    }

    //get请求方式的编码问题
    private void test2(HttpServletRequest request)
            throws UnsupportedEncodingException {
        String username = request.getParameter("name");//是二进制数据  %E6%9D%8E%E5%9B%9B

        byte b[] = username.getBytes("ISO-8859-1");
        username = new String(b,"UTF-8");

        System.out.println(username);//二进制转为字符，用ISO-8859-1的

    }
    //获取请求正文的参数乱码问题
    private void test1(HttpServletRequest request)
            throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");//设置请求正文的编码。只对POST有效

        Student s = new Student();
        System.out.println("封装前："+s);
        try {
            BeanUtils.populate(s, request.getParameterMap());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("封装后："+s);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
