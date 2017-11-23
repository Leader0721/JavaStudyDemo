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
@WebServlet(name = "ServletLogin")
public class ServletLogin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        //验证用户名和密码是否正确 此处输什么都正确
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String remember = request.getParameter("remember");//没有选中就是null  判断这个是不是null


        Cookie cookie = new Cookie("loginInfo", username);
        cookie.setPath(request.getContextPath());

        //根据用户是否记住用户名来决定是否存cookie
        if (remember == null) {
            //没有选中  删除cookie
            cookie.setMaxAge(0);
        } else {
            //用户记住用户名，存Cookie
            cookie.setMaxAge(Integer.MAX_VALUE);
        }
        response.addCookie(cookie);
        out.write("登陆成功");


    }
}
