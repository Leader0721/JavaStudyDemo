package day08Response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 控制缓存的时间
 * 静态资源需要控制缓存时间
 * 动态资源一般不要缓存，因为可能客户端的数据不是最新的
 * Created by 83731 on 2017/08/17.
 */
@WebServlet(name = "ServletDemo0805")
public class ServletDemo0805 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String data = "不见了哈哈哈哈";
        //可以设置让他缓存一个小时   时间是相对于现在的时间的
        response.setDateHeader("Expires", System.currentTimeMillis() + 1 * 60 * 60 * 60);

        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().write(data);
    }
}
