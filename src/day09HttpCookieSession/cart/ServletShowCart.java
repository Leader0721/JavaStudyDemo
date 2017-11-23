package day09HttpCookieSession.cart;

import day09HttpCookieSession.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by 83731 on 2017/09/09.
 */
@WebServlet(name = "ServletShowCart")
public class ServletShowCart extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        List<Book> cart = (List<Book>) session.getAttribute("cart");
        if (cart == null) {
            out.write("您还没有购买任何商品");
            return;
        }

        out.write("<h1>您购买的物品如下</h1>");
        for (Book b : cart) {
            out.write(b.getName() + "</br>");
        }
    }
}
