package listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MyHttpSessionListener implements HttpSessionListener
{
    private static Logger logger = LoggerFactory.getLogger( MyHttpSessionListener.class );
    
    @Override
    public void sessionCreated(HttpSessionEvent se)
    {
        logger.warn("Spring下的 HttpSessionListener 初始化");
    
    }
    
    @Override
    public void sessionDestroyed(HttpSessionEvent se)
    {
        logger.warn( "Spring下的 HttpSessionListener 毁灭" );
    
    }
}
