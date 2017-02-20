package filters;

import javax.servlet.*;
import java.io.IOException;

public class Filter3 implements Filter
{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException
    {
        System.out.println( "第3个过滤器的初始化方法" );
    }
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException
    {
        System.out.println( "第3个过滤器的doFilter方法" );
        chain.doFilter( request,response );
    }
    
    @Override
    public void destroy()
    {
        System.out.println( "第3个过滤器的毁灭方法" );
    }
    
}
