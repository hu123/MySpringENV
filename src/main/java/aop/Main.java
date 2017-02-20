package aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main
{
    public static void main(String[] args)
    {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext( "classpath:spring/aop.xml" );
        HelloWorld hw1 = (HelloWorld) applicationContext.getBean( "helloWorldImpl1");
        hw1.printHelloWorld();
        
        hw1.doPrint();
    }
}
