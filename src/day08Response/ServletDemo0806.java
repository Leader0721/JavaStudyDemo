package day08Response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 演示请求重定向  可以从定向到任何地址上
 * <p>
 * 一共发出了两次请求  一次是 6  一次是  6发出的  7
 * <p>
 * Created by 83731 on 2017/08/17.
 */
@WebServlet(name = "ServletDemo0806")
public class ServletDemo0806 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //第一种方法   比较复杂
//        response.setStatus(302);
//        response.setHeader("Location", "ServletDemo0807");

        response.sendRedirect("ServletDemo0807");
    }
}
