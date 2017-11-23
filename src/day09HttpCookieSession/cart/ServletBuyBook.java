package day09HttpCookieSession.cart;

import day09HttpCookieSession.Book;
import day09HttpCookieSession.BookDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * 把选中的书籍放入到购物车之中
 * Created by 83731 on 2017/09/09.
 */
@WebServlet(name = "ServletBuyBook")
public class ServletBuyBook extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String id = request.getParameter("id");
        Book b = BookDB.findBookById(id);

        //放到HttpSession用List来存
        HttpSession session = request.getSession();
        List<Book> cart = (List<Book>) session.getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<>();
            session.setAttribute("cart", cart);
        }

        //现在肯定有购物车了
        cart.add(b);


        //放到HttpSession
        out.write(b.getName() + "已放入购物车<a href='" + request.getContextPath() + "/session03'>继续购物</a>");

        //为学习原理而做
        Cookie c = new Cookie("JESSIONID", session.getId());
        c.setPath(request.getContextPath());
        c.setMaxAge(Integer.MAX_VALUE);
        response.addCookie(c);


    }
}
