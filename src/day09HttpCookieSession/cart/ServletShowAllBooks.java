package day09HttpCookieSession.cart;

import day09HttpCookieSession.Book;
import day09HttpCookieSession.BookDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

/**
 * 显示所有的可以购买的商品   提供购买链接
 * //提供一个查看购物车的链接
 * Created by 83731 on 2017/09/09.
 */
@WebServlet(name = "ServletShowAllBooks")
public class ServletShowAllBooks extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        //显示所有的商品，提供查看详细内容的链接
        out.write("<h1>本站有以下好书：</h1>");

        Map<String, Book> books = BookDB.findAllBooks();
        for (Map.Entry<String, Book> me : books.entrySet()) {
            out.write(me.getValue().getName() + "&nbsp;&nbsp;<a href='" + request.getContextPath() + "/session04?id=" + me.getKey() + "' target='_blank'>购买</a><br/>");
        }


        //提供一个超链接请求
        out.write("<a href='" + request.getContextPath() + "/session05'>展示购物车内容</a>");

    }
}
