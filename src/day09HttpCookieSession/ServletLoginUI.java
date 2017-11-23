package day09HttpCookieSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by 83731 on 2017/09/06.
 */
@WebServlet(name = "ServletLoginUI")
public class ServletLoginUI extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String username = "";
        String checked = "";
        //得到指定的Cookie
        Cookie cs[] = request.getCookies();
        for (int i = 0; cs != null && i < cs.length; i++) {
            if ("loginInfo".equals(cs[i].getName())) {
                username = cs[i].getValue();
                checked = "checked='checked'";
                break;
            }

        }
        out.write("<form action= '" + request.getContextPath() + "/cookie06' method = 'post'>");
        out.write("用户名:<input type= 'text' name='username' value='" + username + "'/><br/>");
        out.write("密码:<input type= 'password' name='password'/><br/>");
        out.write("记住用户名:<input type= 'checkbox' name='remember' " + checked + "/><br/>");
        out.write("<input type= 'submit' value='登陆'/><br/>");
        out.write("</form>");

    }
}
