package day08Request;



import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;

/**
 * Created by 83731 on 2017/08/19.
 */
@WebServlet(name = "ServletRequest03")
public class ServletRequest03 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    private void test1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");//这边获取参数是不区分是get还是set的
        String password = request.getParameter("password");
        System.out.println(username + password);
    }


    //这个可以获取重名的参数
    private void test2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");//这边获取参数是不区分是get还是set的
        String passwords[] = request.getParameterValues("password");//获取重名的请求参数
        System.out.println(username + Arrays.asList(passwords));
    }

    //获取所有的请求参数名和值
    private void test3(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Enumeration<String> e = request.getParameterNames();
        while (e.hasMoreElements()) {
            String paramName = e.nextElement();
            String values[] = request.getParameterValues(paramName);
            System.out.println(paramName + "=" + Arrays.asList(values));
        }
    }

    //吧请求参数的值封装到JavaBean中
    //约定优于编码 表单中输入域的Name取值和JavaBean中的属性getter和setter方法保持一致
    private void test4(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        Enumeration<String> e = request.getParameterNames();
//        User user = new User();
//        System.out.println("封装前" + user);
//        while (e.hasMoreElements()) {
//            String paramName = e.nextElement();//这个就是JavaBean中的属性
//            String paramValue = request.getParameter(paramName);
//
//            //JavaBean的内省
//            try {
//                PropertyDescriptor pd = new PropertyDescriptor(paramName, User.class);
//                Method m = pd.getWriteMethod();//这个就是setter方法
//                m.invoke(user, paramValue);
//            } catch (Exception e1) {
//                e1.printStackTrace();
//            }
//
//        }
//        System.out.println("封装后" + user);

        Enumeration<String> e = request.getParameterNames();//参数名
        User user = new User();
        System.out.println("封装前：" + user);
        while (e.hasMoreElements()) {
            String paramName = e.nextElement();//即是JavaBean中的属性名称
            String paramValue = request.getParameter(paramName);
//			setUsername(paramValue); setPassword(paramValue);
            //JavaBean的内省
            try {
                PropertyDescriptor pd = new PropertyDescriptor(paramName, User.class);
                Method m = pd.getWriteMethod();//setter方法
                m.invoke(user, paramValue);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
        System.out.println("封装后：" + user);

    }


    //getParamterMap获取参数
    private void test6(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> map = request.getParameterMap();
        for (Map.Entry<String, String[]> me : map.entrySet()) {
            System.out.println(me.getKey() + "=" + Arrays.asList(me.getValue()));
        }
    }


    //封装到JavaBean中
    private void test7(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> map = request.getParameterMap();
        User user = new User();
        System.out.println("封装前：" + user);
        for (Map.Entry<String, String[]> me : map.entrySet()) {
            String paramName = me.getKey();//参数名称
            String[] paramValues = me.getValue();//参数值
            try {
                PropertyDescriptor pd = new PropertyDescriptor((String) paramName, User.class);
                Method m = pd.getWriteMethod();//setter方法

                if (paramValues.length > 1) {
                    m.invoke(user, (Object) paramValues);
                } else {
                    m.invoke(user, paramValues);
                }
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            System.out.println("封装后：" + user);
        }
    }


    //终极解决方案
    private void test8(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();
        System.out.println("封装前" + user);
        try {
            BeanUtils.populate(user,request.getParameterMap());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println("封装后" + user);
    }


//    private void test5(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        User user = new User();
//        System.out.println("封装前" + user);
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//        user.setPassword(password);
//        user.setUsername(username);
//        System.out.println("封装后" + user);
//    }


    //下面的比较复杂的


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        test8(request, response);
    }
}
