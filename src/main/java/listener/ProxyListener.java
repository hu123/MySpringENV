package listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.Collection;

public class ProxyListener implements ServletContextListener
{
    private static Logger logger = LoggerFactory.getLogger( ProxyListener.class );
    private ApplicationContext applicationContext;
    
    @Override
    public void contextInitialized(ServletContextEvent sce)
    {
        logger.warn( "代理的Listener先初始化" );
        applicationContext = WebApplicationContextUtils.getWebApplicationContext( sce.getServletContext() );
        Collection<ServletContextListener> collection = applicationContext.getBeansOfType( ServletContextListener.class ).values();
        
        logger.warn( "有几个ServletContextListener------------->" + collection.size()  );
        
        for(ServletContextListener servletContextListener : collection)
        {
            servletContextListener.contextInitialized( sce );
        }
        
    }
    
    
    @Override
    public void contextDestroyed(ServletContextEvent sce)
    {
        if(applicationContext == null)
        {
            logger.error( "没找到应用上下文" );
        }
        System.out.println( "代理的Listener将要destroy" );
        Collection<ServletContextListener> collection = applicationContext.getBeansOfType( ServletContextListener.class ).values();
        for(ServletContextListener servletContextListener : collection)
        {
            servletContextListener.contextDestroyed( sce );
        }
    }
}
