package aop;

public class TimeHandler
{
    public void before()
    {
        System.out.println("之前的日志" );
        
    }
    
    public void after()
    {
        System.out.println( "之后的日志" );
    }
}
