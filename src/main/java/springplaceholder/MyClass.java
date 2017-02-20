package springplaceholder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import springInitializingBeanInterfaceTest.MySpringInitializingBeanTest;

public class MyClass
{
    private static Logger logger = LoggerFactory.getLogger( MyClass.class );
    
    private String username ;
    private String password ;
    
    public String getUsername()
    {
        return username;
    }
    
    public void setUsername(String username)
    {
        this.username = username;
    }
    
    public String getPassword()
    {
        return password;
    }
    
    public void setPassword(String password)
    {
        this.password = password;
    }
    
    public static void main(String[] args)
    {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext( "classpath:/spring/placeholder.xml" );
        MyClass myClass = applicationContext.getBean( "myClass", MyClass.class );
        logger.warn( "内容->" + myClass.getUsername() );
        logger.warn( "内容->" + myClass.getPassword() );
    
        MySpringInitializingBeanTest mySpringInitializingBeanTest = applicationContext.getBean( "mySpringInitializingBeanTest", MySpringInitializingBeanTest.class );
        
        mySpringInitializingBeanTest.sayHello();
    }
    
}
