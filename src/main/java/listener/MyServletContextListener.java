package listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import springmvcpackage.MyServlet;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyServletContextListener implements ServletContextListener
{
    private static Logger logger = LoggerFactory.getLogger( MyServletContextListener.class );
    
    @Override
    public void contextInitialized(ServletContextEvent sce)
    {
        logger.warn("Spring下的 ServletContextListener 初始化");
    }
    
    @Override
    public void contextDestroyed(ServletContextEvent sce)
    {
        logger.warn( "Spring下的 ServletContextListener 毁灭" );
    
    }
}
