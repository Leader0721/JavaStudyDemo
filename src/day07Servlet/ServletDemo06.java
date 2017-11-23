package day07Servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 对Servlet进行参数的配置
 * ServletConfig:代表Servlet的参数配置
 * <p>
 * <p>
 * <init-param>
 * <param-name>XXXX</param-name>
 * <param-value>YYYY</param-value>
 * </init-param>
 * <p>
 * 代表的就是上面的这一部分的内容
 * <p>
 * <p>
 * 如何得到Servlet中的对象的引用：在初始化Servlet时，由容器进行产生，并传递过去
 * <p>
 * <p>
 * <p>
 * <p>
 * Created by 83731 on 2017/08/14.
 */
@WebServlet(name = "ServletDemo06")
public class ServletDemo06 extends HttpServlet {

//    这种写法仅供了解
//    private ServletConfig config;
//    public void init(ServletConfig config) throws ServletException {
//        this.config = config;
//    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //使用ServletConfig
        ServletConfig config = getServletConfig();

//        得到指定名称的参数值
        String value = config.getInitParameter("encoding");
        System.out.println(value);
    }
}
