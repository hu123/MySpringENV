package servlet;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.*;
import java.io.IOException;

/**
 * 静态代理模式
 */
public class SpringServletDelegatingProxy extends GenericServlet
{
    private String targetBean ;
    private Servlet proxy;
    
    @Override
    public void init() throws ServletException
    {
        this.targetBean = getInitParameter( "targetBean" );
        getServletBean();
        proxy.init( getServletConfig() );
        
    }
    
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException
    {
        proxy.service( req, res );
        
    }
    private void getServletBean()
    {
        WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getServletContext() );
        this.proxy = (Servlet) wac.getBean( targetBean );
    }
}
