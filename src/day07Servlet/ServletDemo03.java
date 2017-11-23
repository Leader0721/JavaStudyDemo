package day07Servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet的生命周期
 * Created by 83731 on 2017/08/13.
 */

//Servlet的生命周期
@WebServlet(name = "ServletDemo03")
public class ServletDemo03 extends HttpServlet {
    //    用户第一次访问的时候   只执行依次
    public ServletDemo03() {
        System.out.println("调用了Servlet的默认构造方法");
    }


    //    用户第一次访问的时候，只执行一次，用于对象的初始化
    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("调用了Servlet的默认构造方法");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }


    //    每次用户访问都会执行
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("执行了Service方法");
    }

    //只调用了一次
    @Override
    public void destroy() {
        System.out.println("调用了Servlet的销毁方法，只调用了一次");
    }
}
