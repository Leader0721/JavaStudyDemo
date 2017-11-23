package day07Servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

/**
 * 实现了中文文件的下载  并命名
 * Created by 83731 on 2017/08/15.
 */
@WebServlet(name = "ServletDemo12")
public class ServletDemo12 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //文件在那个地方?以不变应万变
        ServletContext sc = getServletContext();
        String realPath = sc.getRealPath("/WEB-INF/classes/美女.png");//这个名字一定不能写错呀   啊啊啊啊
        //因为应用运行之后所有的资源都会输出到classes中，然后直接到classes中进行下载是以不变应万变
        //这个就是文件存放的真实的绝对路径  都必须以/开头，代表的是当前的应用
        System.out.println(realPath);

        //构建文件的输入流
        InputStream in = new FileInputStream(realPath);


        //告知客户端用下载的方式打开

        //如果图片直接展示出来的话，要设置上清理缓存
        response.setHeader("Content-Type", "application/octet-stream");


        //获取到要下载的文件的名字，而不是写死
        String fileName = realPath.substring(realPath.lastIndexOf(File.separator) + 1);
        //Content-Disposition=attachment;filename=model.jsp
        //这个问题一定要尝试多换几个浏览器，有的浏览器不行
        response.setHeader("Content-disposition", "attachment;filename=" + URLEncoder.encode(fileName,"UTF-8"));//中文是属于不安全的，需要进行URL编码



        //用response的字节流进行输出
        OutputStream out = response.getOutputStream();
        int len = -1;
        byte b[] = new byte[1024];
        while ((len = in.read(b)) != -1) {
            out.write(b, 0, len);
        }

        in.close();
        out.close();

    }
}
