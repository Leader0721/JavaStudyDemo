package day19_01_filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by 83731 on 2017/11/02.
 */
public class FilterDemo01 implements Filter {
    public FilterDemo01() {
        System.out.println("调用了默认的构造方法");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("调用初始化方法");
    }

    //用户每次访问被过滤的资源，都会被服务器调用该方法实现过滤
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("FilterDemo执行过滤了 ");

        //对请求进行拦截，代码写在这里
        filterChain.doFilter(servletRequest, servletResponse);
        //对响应进行拦截，代码写在这里
    }

    @Override
    public void destroy() {
        System.out.println("调用了销毁方法");
    }
}
