package day08Request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * HttpServletRequest中的常用方法
 * <p>
 * Created by 83731 on 2017/08/17.
 */
@WebServlet(name = "ServletRequest01")
public class ServletRequest01 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getMethod();//请求方式
        String uri = request.getRequestURI();//获取文件的位置  day07_01_servlet/day08Request/ServletRequest01
        String url = request.getRequestURL().toString();//http://localhost:8080/day07_01_servlet/day08Request/ServletRequest01
        String protocal = request.getProtocol();//客户端使用的协议

        String remoteIp = request.getRemoteAddr();//获取来访者的Ip
        int port = request.getRemotePort();//获取来访者使用的端口  每个软件的端口号都不同 这个是随机的   并不是 8080   8080是服务器的端口，

        String queryString = request.getQueryString();//GET方式：/day08_01_request/servlet/RequestDemo1?username=3234&password=1212

        System.out.println(method);
        System.out.println(uri);
        System.out.println(url);
        System.out.println(protocal);
        System.out.println(remoteIp);
        System.out.println(port + "");
        System.out.println(queryString);
    }
}
