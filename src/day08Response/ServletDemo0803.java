package day08Response;

import com.sun.corba.se.impl.orbutil.graph.Graph;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * 输出随机验证码图片       CAPTCHA全自动区分计算机和人类的测试
 * Created by 83731 on 2017/08/16.
 */
@WebServlet(name = "ServletDemo0803")
public class ServletDemo0803 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //创建一副内存图像
        int width = 120;
        int height = 25;
        int imageType = BufferedImage.TYPE_INT_RGB;

        BufferedImage image = new BufferedImage(width, height, imageType);


        //得到画笔
        Graphics g = image.getGraphics();

        //开始画
        //设置边线
        g.setColor(Color.BLUE); //blue  BLUE 大写的是标准的    blue是不标准
        g.drawRect(0, 0, width, height);
        g.setColor(Color.YELLOW);
        g.fillRect(1, 1, width - 2, height - 2);

        //画干扰线
        g.setColor(Color.GRAY);
        Random random = new Random();
        //根据画几条可以循环画
        for (int i = 0; i < 3; i++) {
            g.drawLine(random.nextInt(width), random.nextInt(height), random.nextInt(width), random.nextInt(height));
        }

        //画验证码
        g.setColor(Color.RED);
        g.setFont(new Font("宋体", Font.ITALIC | Font.BOLD, 19));

        int x = 20;
        String base = "\u7684\u4e00\u7684\u4e00\u7684\u4e00\u7684\u4e00\u7684\u4e00\u7684\u4e00\u7684\u4e00\u7684\u4e00\u7684\u4e00";
        for (int i = 0; i < 4; i++) {

            //这个是填充数字的
            g.drawString(random.nextInt(10) + "", x, 20);

            //这个是填充汉字的
            g.drawString(base.charAt(random.nextInt(base.length())) + "", x, 20);


            x += 18;

        }
        response.setHeader("Expires", "-1");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        //输出
        ImageIO.write(image, "jpg", response.getOutputStream());
    }
}
