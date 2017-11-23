package day08Response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

/**
 * 控制客户端并且使之刷新
 * Created by 83731 on 2017/08/17.
 */
@WebServlet(name = "ServletDemo0804")
public class ServletDemo0804 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        Random random = new Random();
//        response.setHeader("Refresh", "1");//这个还有进行字符串到整数的转化
//        response.setIntHeader("Refresh", 1);
//        response.getWriter().write(random.nextInt() + "");


        test02(request, response);
    }


    //定时刷新到别处
    protected void test02(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        Random random = new Random();
//        response.setHeader("Refresh", "1");//这个还有进行字符串到整数的转化
//        response.setIntHeader("Refresh", 1);
//        response.getWriter().write(random.nextInt() + "");
        response.setContentType("text/html;charset=UTF-8");
        response.setHeader("Refresh","2;URL=http://www.baidu.com");
        response.getWriter().write("登录成功，两秒后跳转到主页");

    }
    //定时刷新到自己
    protected void test01(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        Random random = new Random();
//        response.setHeader("Refresh", "1");//这个还有进行字符串到整数的转化
//        response.setIntHeader("Refresh", 1);
//        response.getWriter().write(random.nextInt() + "");


    }
}
