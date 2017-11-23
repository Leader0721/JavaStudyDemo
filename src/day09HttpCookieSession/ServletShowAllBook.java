package day09HttpCookieSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

/**
 * 显示所有的商品，提供查看详细内容的链接
 * 显示最近的浏览记录  3条
 * Created by 83731 on 2017/09/07.
 */
@WebServlet(name = "ServletShowAllBook")
public class ServletShowAllBook extends HttpServlet {
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        doGet(request, response);
//    }
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        PrintWriter out = response.getWriter();
//
//
//        //显示所有的商品 提供查看详细内容的链接
//        out.write("<h1>本站有以下好书:</h1>");
//        Map<String, Book> bookMap = BookDB.findAllBooks();
//        for (Map.Entry<String, Book> me : bookMap.entrySet()) {
//            out.write(me.getValue().getName() + "&nbsp;&nbsp;<a href='" + request.getContextPath() + "/cookie08?id=" + me.getKey() + "'target='_blank'>查看详细</a><br/>");
//        }
//        //显示最近的浏览记录  3条  bookHistory=2-1-3
//        out.write("<hr/>您最近的浏览记录如下：<br/>");
//        Cookie cs[] = request.getCookies();
//        for (int i = 0; cs != null && i < cs.length; i++) {
//            if ("bookHistory".equals(cs[i].getName())) {
//                String value = cs[i].getValue();//2-1-3
//                String ids[] = value.split("\\-");
//                for (String id : ids) {
//                    out.write(BookDB.findBookById(id).getName() + "<br/>");
//                }
//                break;
//            }
//        }
//
//
//    }
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        //显示所有的商品，提供查看详细内容的链接
        out.write("<h1>本站有以下好书：</h1>");

        Map<String, Book> books = BookDB.findAllBooks();
        for(Map.Entry<String, Book> me:books.entrySet()){
            out.write(me.getValue().getName()+"&nbsp;&nbsp;<a href='"+request.getContextPath()+"/cookie08?id="+me.getKey()+"' target='_blank'>查看详细</a><br/>");
        }

        //显示最近的浏览记录：3条  bookHistory=2-1-3
        out.write("<hr/>您最近的浏览记录如下：<br/>");
        Cookie cs[] = request.getCookies();
        for(int i=0;cs!=null&&i<cs.length;i++){
            if("bookHistory".equals(cs[i].getName())){
                String value = cs[i].getValue();// 2-1-3
                String ids[] = value.split("\\-");
                for(String id:ids){
                    out.write(BookDB.findBookById(id).getName()+"<br/>");
                }

                break;
            }
        }

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }


}
