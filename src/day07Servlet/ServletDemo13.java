package day07Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 * 读取配置文件的各种方式
 * Created by 83731 on 2017/08/16.
 */
@WebServlet(name = "ServletDemo13")
public class ServletDemo13 extends HttpServlet {
    private void test10(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //利用ServletContext读取properties
        //可以读取应用中任何位置上的资源  只能在web应用中


//        String path = getServletContext().getRealPath("/a.properties");
//        String path = getServletContext().getRealPath("/WEB-INF/classes/b.properties");
        String path = getServletContext().getRealPath("/WEB-INF/classes/filecopy/c.properties");

        InputStream in = new FileInputStream(path);
        Properties properties = new Properties();
        properties.load(in);
        System.out.println(properties.getProperty("ren"));
    }


    //利用ServletContext 读取 a  b   c
    //利用ResourceBundle读取: b   c    不能读  a    只能读取properties的文件
    private void test20(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        ResourceBundle rb = ResourceBundle.getBundle("b");
        ResourceBundle rb = ResourceBundle.getBundle("filecopy.c");
        System.out.println(rb.getString("ren"));
    }


    //利用类加载器读取:只能读取classes或者路径中的任意资源，但是不适合读取特别大的资源
    //一般读取  b  c 因为将文件看成一个类
    private void test30(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ClassLoader cl = ServletDemo13.class.getClassLoader();//得到加载器
//        InputStream in = cl.getResourceAsStream("b.properties");
//        InputStream in = cl.getResourceAsStream("filecopy/b.properties");
        InputStream in = cl.getResourceAsStream("ren/tong/shuai/b.properties");
        Properties properties = new Properties();
        properties.load(in);
        System.out.println(properties.getProperty("ren"));
    }

    //利用类加载器读取:只能读取classes或者路径中的任意资源，但是不适合读取特别大的资源
    //一般读取  b  c 因为将文件看成一个类
    private void test31(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ClassLoader cl = ServletDemo13.class.getClassLoader();//得到加载器
//        InputStream in = cl.getResourceAsStream("b.properties");
//        InputStream in = cl.getResourceAsStream("filecopy/b.properties");
        URL url = cl.getResource("ren/tong/shuai/c.properties");
        String path = url.getPath();
        InputStream in = new FileInputStream(path);
        Properties properties = new Properties();
        properties.load(in);
        System.out.println(properties.getProperty("ren"));
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        test31(request, response);
    }
}
