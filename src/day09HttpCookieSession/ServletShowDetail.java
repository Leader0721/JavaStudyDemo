package day09HttpCookieSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 显示商品的详细内容
 * 组织数据，向客户端写cookie
 * Created by 83731 on 2017/09/07.
 */
@WebServlet(name = "ServletShowDetail")
public class ServletShowDetail extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        //显示上面的详细内容
        String id = request.getParameter("id");
        Book book = BookDB.findBookById(id);
        out.write(book.toString());


        //组织数据，向客户端写Cookie    3条  bookHistory=2-1-3
        String bookId = makeId(id, request);
        Cookie c = new Cookie("bookHistory", bookId);
        c.setPath(request.getContextPath());
//        response.getco

        //一定记住要把Cookie文件最后添加上，返回回去
        response.addCookie(c);
    }

    //组织数据

    /**
     * Cookie                         当前访问的书的Id               应该写回去的新的Id
     * Cookie                        为null     1                   bookHistory = 1;
     * Cookie            不为null但是没有bookHistory     1          bookhistory = 1
     * bookHistory = 1                  2                          bookHistory = 2-1
     * bookHistory = 2-1                   3                      bookHistory = 3-2-1
     * bookHistory = 3-2-1                4                      bookHistory = 4-3-2
     *
     * @param id
     * @param request
     * @return
     */
    private String makeId(String id, HttpServletRequest request) {
        Cookie cs[] = request.getCookies();
        if (cs == null) {
            return id;
        }

        Cookie bookHistoryCookies = null;
        for (Cookie c : cs) {
            if ("bookHistory".equals(c.getName())) {
                bookHistoryCookies = c;
                break;
            }
        }
        if (bookHistoryCookies == null) {
            return id;
        }
        //下面分两种情况 一种是两个的
        String value = bookHistoryCookies.getValue();
        String ids[] = value.split("\\-");
        LinkedList<String> list = new LinkedList<String>(Arrays.asList(ids));
        if (list.size() < 3) {
            if (list.contains(id)) {
                list.remove(id);
            }

        } else {
            //一种是三个的  可以更新的
            if (list.contains(id)) {//包含的话，移除最后一个
                list.remove(id);
            } else {
                list.removeLast();
            }
        }

        list.addFirst(id);
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < list.size(); i++) {
            if (i > 0) {
                sb.append("-");
            }
            sb.append(list.get(i));
        }
        return sb.toString();

    }
}
