package day09HttpCookieSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * Created by 83731 on 2017/08/21.
 */
@WebServlet(name = "ServletCookie01")
public class ServletCookie01 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter printWriter = response.getWriter();
        printWriter.write("您上次访问的时间是:");
//        printWriter.write("您上次访问的时间是:");
        printWriter.write("您上次访问的时间:<a href = '" + request.getContextPath() + "/cookie02'>清除时间</a>是:");

        //获取指定名称的Cookie lastAccessTime = 毫秒值
        Cookie cs[] = request.getCookies();
        for (int i = 0; cs != null && i < cs.length; i++) {
            if ("lastAccessTime".equals(cs[i].getName())) {
                //这个代表找到了
                long time = Long.parseLong(cs[i].getValue());
                printWriter.write(new Date(time).toLocaleString());

            }

        }


        //把当前的时间写回去
        //Cookie默认的生命周期是一次会话
        Cookie c = new Cookie("lastAccessTime", System.currentTimeMillis() + "");
        c.setMaxAge(Integer.MAX_VALUE);//单位是秒  Integer.MaxValue 这个是代表永久
        response.addCookie(c);


    }
}
