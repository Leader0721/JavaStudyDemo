package day07Servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * 获取应用级的参数
 * Created by 83731 on 2017/08/15.
 */
@WebServlet(name = "ServletDemo09")
public class ServletDemo09 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext sc = getServletContext();

        //这个是得一个参数
        String value = sc.getInitParameter("encoding");
        response.getWriter().write(value);

        //得到所有的参数
        Enumeration<String> names = sc.getInitParameterNames();
        while (names.hasMoreElements()) {
            String paramName = names.nextElement();
            response.getWriter().write(paramName);
        }
    }
}
