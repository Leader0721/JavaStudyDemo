package day09HttpCookieSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by 83731 on 2017/09/09.
 */
@WebServlet(name = "ServletSession01")
public class ServletSession01 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String name = request.getParameter("name");
        if (name == null) {
            out.write("请这样访问:http://192.168.0.113:8080/hello/session01?name=abc");
            return;
        }

        //得到httpSession的实例
        HttpSession session = request.getSession();
        session.setAttribute("p", name);
        out.write("放了<a href='http://192.168.0.113:8080/hello/session02'>去看看</a>");
//http://192.168.0.113:8080/hello/session01?name=abc

    }
}
