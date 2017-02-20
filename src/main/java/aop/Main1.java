package aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main1
{
    public static void main(String[] args)
    {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext( "classpath:spring/aop.xml" );
    
        UserManager userManager = (UserManager) applicationContext.getBean( "userManager" );
    
        userManager.sayHello();
    
        System.out.println(userManager.getClass().getName());
    }
}
