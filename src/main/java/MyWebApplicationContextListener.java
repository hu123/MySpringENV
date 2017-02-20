import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyWebApplicationContextListener implements ServletContextListener
{
    
    @Override
    public void contextInitialized(ServletContextEvent sce)
    {
        ServletContext servletContext = sce.getServletContext();
        
        WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext( servletContext );
        
        String[] beanNames = webApplicationContext.getBeanDefinitionNames();
    
        System.out.println("服务器启动时: 拿到WebApplicationContext里面Bean的名字是::::" );
        
        for(String beanName : beanNames)
        {
            System.out.println(beanName);
        }
    
    
        
    }
    
    @Override
    public void contextDestroyed(ServletContextEvent sce)
    {
        
    }
}
