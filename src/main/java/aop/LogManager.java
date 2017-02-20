package aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 切面类
 */
@Component
@Aspect
public class LogManager
{

    @Pointcut("execution(public void aop.UserManager.sayHello())")
//    @Pointcut("execution(public String springmvcpackage.MyController.sayHello(*))")
    public void allMethod()
    {
        
    }


    @Before( "allMethod()" )
    public void before()
    {
        System.out.println( "前日志" );
    }

    @After( "allMethod()" )
    public void after()
    {
        System.out.println("后日志");
    }

}
