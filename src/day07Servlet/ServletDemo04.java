package day07Servlet;

import javax.servlet.ServletException;
import javax.servlet.SingleThreadModel;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet的线程安全
 * 看服务器如何实现
 * 1.对数据进行枷锁处理   这样是行不通的
 * 2.在内存中创建ServletDemo4的多个实例  行不通
 * 3.尽量使用局部变量， 不要使用实例变量
 * <p>
 * <p>
 * Created by 83731 on 2017/08/14.
 */
@WebServlet(name = "ServletDemo04")
public class ServletDemo04 extends HttpServlet implements SingleThreadModel {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        尽量使用局部变量  不要使用实例变量
        int num = 1;

        num++;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("ddddddddd" + num);
    }
}
