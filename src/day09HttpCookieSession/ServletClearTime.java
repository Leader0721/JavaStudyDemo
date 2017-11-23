package day09HttpCookieSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 清除指定的cookie
 * Created by 83731 on 2017/09/06.
 */
@WebServlet(name = "ServletClearTime")
public class ServletClearTime extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //如何唯一定位要删除的Cookie:domain+path+name  新添加一个cookie 会将原来的给覆盖掉
        Cookie c = new Cookie("lastAccessTime","");
        c.setMaxAge(0);
        response.addCookie(c);

    }
}
