package springInitializingBeanInterfaceTest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class MySpringInitializingBeanTest implements InitializingBean ,DisposableBean
{
    
    private static Logger logger = LoggerFactory.getLogger( MySpringInitializingBeanTest.class );
    
    
    public void init()
    {
        logger.warn( "内容是->用户自定义的init方法" );
    }
    
    @Override
    public void afterPropertiesSet() throws Exception
    {
        logger.warn( "内容是-> InitializingBean提供的方法" );
    }
    
    @Override
    public void destroy() throws Exception
    {
        logger.warn( "内容是-> 使用一次就丢弃的bean" );
    }
    
    
    public void sayHello()
    {
        System.out.println( "你好世界" );
    }
}
