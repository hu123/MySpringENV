package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 交给Spring管理的Servlet
 */
public class MySpringServlet extends HttpServlet
{
    
    @Override
    public void init() throws ServletException
    {
        System.out.println( "交给Spring管理的Servlet也能被init????" );
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        System.out.println( "这是我的SpringServlet" );
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        this.doGet( req,resp );
    }
}
