package day07Servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 83731 on 2017/08/15.
 * <p>
 * 和ServletDemo08实现数据的共享
 */
@WebServlet(name = "ServletDemo07")
public class ServletDemo07 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext sc = getServletContext();
        sc.setAttribute("p", "ppp");
        response.getWriter().write("put one p");
    }
}
