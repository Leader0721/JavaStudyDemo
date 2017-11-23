package day08Response;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 向客户端输出中文数据
 * Created by 83731 on 2017/08/16.
 */
@WebServlet(name = "ServletDay0801")
public class ServletDemo0801 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String data = "不见了远处的青山";
//        ServletOutputStream servletOutputStream = response.getOutputStream();
//        servletOutputStream.write(data.getBytes()); //String :  getBytes() 查本地的默认的码表GBK  getBytes(String charset)
        test01(request, response);

    }

    protected void test01(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String data = "不见了远处的青山";
        ServletOutputStream servletOutputStream = response.getOutputStream();
        //String :  getBytes() 查本地的默认的码表GBK  getBytes(String charset)
        //默认情况下是乱码的
        //解决方案1  更改浏览器的码表  将GBK改成UTF-8
        //解决方案2  向客户端输出一个<meta>标签   但是这个标签太长，不容易记住
        // 模拟了响应消息头  "<meta http-equiv='Content-Type' content='text/html;charset=UTF-8'>"
//        servletOutputStream.write("<meta http-equiv='Content-Type' content='text/html;charset=UTF-8'>".getBytes());
//        servletOutputStream.write(data.getBytes("UTF-8"));


        //解决方案3  向客户端输出响应消息头:Content-Type:text/html;charset=UTF-8

//        response.setHeader("Content-Type","text/html;charset=UTF-8");
//        servletOutputStream.write(data.getBytes("UTF-8"));


        //解决方案4 向客户输出客户响应消息头    response.setContentType("text/html;charset=UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        servletOutputStream.write(data.getBytes("UTF-8"));

    }

    protected void test02(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String data = "不见了远处的青山";
        ServletOutputStream servletOutputStream = response.getOutputStream();
        servletOutputStream.write(data.getBytes()); //String :  getBytes() 查本地的默认的码表GBK  getBytes(String charset)


    }


}
