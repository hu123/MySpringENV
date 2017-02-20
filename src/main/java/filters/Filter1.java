package filters;

import javax.servlet.*;
import java.io.IOException;

public class Filter1 implements Filter
{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException
    {
        System.out.println( "第一个过滤器的初始化方法" );
    }
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException
    {
        ProxyFilterChain proxyFilterChain = new ProxyFilterChain();
        
        
        System.out.println( "第一个过滤器的doFilter方法" );
        
        chain.doFilter( request,response );
    }
    
    @Override
    public void destroy()
    {
        System.out.println( "第一个过滤器的毁灭方法" );
    }
    
    private static final class ProxyFilterChain implements FilterChain
    {
        private boolean invokeNextFilter = false;
    
        @Override
        public void doFilter(ServletRequest request, ServletResponse response) throws IOException, ServletException
        {
            this.invokeNextFilter = true;
            
        }
    
        public boolean isInvokeNextFilter()
        {
            return invokeNextFilter;
        }
    
        public void setInvokeNextFilter(boolean invokeNextFilter)
        {
            this.invokeNextFilter = invokeNextFilter;
        }
    }
    
}
