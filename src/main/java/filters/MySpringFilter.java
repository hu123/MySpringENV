package filters;

import javax.servlet.*;
import java.io.IOException;

public class MySpringFilter implements Filter
{
    
    
    private String name ;
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException
    {
        System.out.println( "要调用init哦" );
        
    }
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException
    {
        System.out.println( "要调用哦doFilter" );
    
        System.out.println(name);
        chain.doFilter( request, response );
    }
    
    @Override
    public void destroy()
    {
        System.out.println( "要调用哦destroy" );
    }
}
