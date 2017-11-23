package day19_01_autologin.controller;

import day19_01_autologin.bean.User;
import day19_01_autologin.service.BusinessService;
import day19_01_autologin.serviceImpl.BusinessServiceImpl;
import day19_01_autologin.util.SecurityUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 83731 on 2017/11/05.
 */
@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    private BusinessService s = new BusinessServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String auto = request.getParameter("auto");

        User user = s.login(username, password);
        if (user == null) {
            response.getWriter().write("错误的用户名或密码");
            return;
        }
        request.getSession().setAttribute("user", user);
        //根据用户是否记住，保存用户名和密码  Cookie  loginInfo = yonghuming
        if (auto != null) {
            //cookie是不能存储中文的
            Cookie cookie = new Cookie("loginInfo", SecurityUtil.base64encode(username) + "_" + SecurityUtil.md5(password));
            cookie.setPath(request.getContextPath());
            cookie.setMaxAge(Integer.MAX_VALUE);
            response.addCookie(cookie);
        }
        response.sendRedirect(request.getContextPath());
    }
}
