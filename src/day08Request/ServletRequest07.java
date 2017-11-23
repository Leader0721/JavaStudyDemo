package day08Request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 83731 on 2017/08/20.
 * <p>
 * 和目标请求共享的数据
 */
@WebServlet(name = "ServletRequest07")
public class ServletRequest07 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String s = (String) request.getAttribute("p");//这个相当于Intent  和getParameter没有关系
        response.getWriter().write(s);
    }
}
