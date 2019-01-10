package geoorg.start.example.filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * Created by gaw on 3/19/2018.
 */
@WebFilter("/*")
public class ExampleFilter implements Filter {
    @Override
    public void init(final FilterConfig filterConfig) throws ServletException {
        System.out.println("ExampleFilter.init");
    }

    @Override
    public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain chain) throws IOException, ServletException {
        System.out.println("ExampleFilter.doFilter");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        System.out.println("ExampleFilter.destroy");
    }
}
