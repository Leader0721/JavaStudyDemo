package day19_01_filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by 83731 on 2017/11/02.
 */
public class FilterDemo03 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("FilterDemo03前");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("FilterDemo03后");
    }

    @Override
    public void destroy() {

    }
}
