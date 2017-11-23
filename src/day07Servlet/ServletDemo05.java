package day07Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet的一些细节
 * 1.一个Servlet可以映射到多个地址之上
 * 2.可以使用地址通配符
 * 写法一  * .do  只要是以.do 进行结尾的都会访问相应的Servlet
 * 写法二(比一的优先级高) 以/开头  必须以 *结尾  比如/action/*   然后*之后的可以写任何东西，都会被匹配
 * 3.默认的Servlet映射路径是 <url-pattern>/</url-pattern>   不需要大家配，因为默认的映射路径负责匹配大家找不到匹配的处理工作
 *      一切都是Servlet  一个网页也是一个Servlet
 *
 *  4.服务器第一次启动的时候回比较慢，这个时候可以对Servlet的初始化进行排序
 * Created by 83731 on 2017/08/14.
 */
@WebServlet(name = "ServletDemo05")
public class ServletDemo05 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
