package day08Response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 字符流输出中文数据   一般最好还是用字符流输出中文数据    字节流用于输出文件
 * Created by 83731 on 2017/08/16.
 */
@WebServlet(name = "ServletDemo0802")
public class ServletDemo0802 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String data = "幸福是 什么";
        //解决乱码的方法  改变字符流查的码表
        response.setCharacterEncoding("UTF-8");
        //然后告知客户端用UTF-8进行解码
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter printWriter = response.getWriter();
        //HttpServletResponse的实例由Tomcat服务器提供 默认查 ISO-8859-1的
        //Tomcat8 的默认编码就变成了  UTF-8
        printWriter.write(data);
        test1(request, response);
    }

    private void test1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String data = "幸福 是dfasdfsafasfsadfasdfasfasd什么";

        //解决乱码的方法  改变字符流查的码表
        // 还能  告知客户端用UTF-8进行解码
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter printWriter = response.getWriter();
        //HttpServletResponse的实例由Tomcat服务器提供 默认查 ISO-8859-1的
        //Tomcat8 的默认编码就变成了  UTF-8
        printWriter.write(data);
    }
}
