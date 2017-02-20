package filters;

import javax.servlet.*;
import java.io.IOException;

public class AnotherSpringFilter implements Filter
{
    
    private String name ;
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException
    {
        System.out.println("另一个SpringFilter的初始化方法");
    }
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException
    {
        System.out.println("另一个SpringFilter的doFilter方法" + name);
    
    }
    
    @Override
    public void destroy()
    {
        System.out.println("另一个SpringFilter的destroy方法");
    
    }
}
