package day08Request;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 83731 on 2017/08/20.
 */
@WebServlet(name = "ServletRequest06")
public class ServletRequest06 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("p", "ppp");

        //ServletContext地址的写法。必须以"/",代表当前的应用(应用开头的绝对路径)
        //开发中尽量使用绝对路径

//        RequestDispatcher rq = getServletContext().getRequestDispatcher("/request07");

        RequestDispatcher rq = request.getRequestDispatcher("/request07");
        rq.forward(request, response);
    }
}
