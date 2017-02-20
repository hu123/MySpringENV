package listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.Collection;

public class ProxyListener1 implements HttpSessionListener
{
    private static Logger logger = LoggerFactory.getLogger( ProxyListener1.class );
    
    private ApplicationContext applicationContext ;
    
    @Override
    public void sessionCreated(HttpSessionEvent se)
    {
    
        applicationContext = WebApplicationContextUtils.getWebApplicationContext( se.getSession().getServletContext() );
        
        if(applicationContext == null)
        {
            throw new RuntimeException( "这个异常" );
        }
        logger.warn( "代理Listener session将要init" );
        
        Collection<HttpSessionListener> collection = applicationContext.getBeansOfType( HttpSessionListener.class ).values();
        
        
        logger.warn( "有几个HttpSessionListener" +collection.size() );
        
        
        for(HttpSessionListener httpSessionListener : collection)
        {
            httpSessionListener.sessionCreated( se );
        }
    }
    
    
    @Override
    public void sessionDestroyed(HttpSessionEvent se)
    {
        if(applicationContext == null)
        {
            throw new RuntimeException( "这个异常2" );
        }
        logger.warn( "代理Listener session 将要destroy" );
        Collection<HttpSessionListener> collection = applicationContext.getBeansOfType( HttpSessionListener.class ).values();
        for(HttpSessionListener httpSessionListener : collection)
        {
            httpSessionListener.sessionDestroyed( se );
        }
    }
}
