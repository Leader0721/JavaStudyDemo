package day09HttpCookieSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by 83731 on 2017/09/09.
 */
@WebServlet(name = "ServletSession02")
public class ServletSession02 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        HttpSession session = request.getSession();
//        String v = (String) session.getAttribute("p");
//        response.getWriter().write(v);
        HttpSession session = request.getSession();
//        System.out.println("SessionDemo2中HttpSession对象的id："+session.getId());
        String v = (String)session.getAttribute("p");
        response.getWriter().write(v);

    }
}
