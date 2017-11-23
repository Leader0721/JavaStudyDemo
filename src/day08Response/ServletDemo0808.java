package day08Response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * response 的一些细节
 * 1.字节流和字符流互斥 不能公用
 *
 * 2.response 中的流可以自己自动关闭
 *
 *
 *
 * Created by 83731 on 2017/08/17.
 */
@WebServlet(name = "ServletDemo0808")
public class ServletDemo0808 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().write("I  am  0000");
//        response.getOutputStream().write("a".getBytes());   这种方法是错误的，字节流和字符流不能共同使用，否则报错
    }
}
