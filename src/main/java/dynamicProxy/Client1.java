package dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Client1
{
    public static void main(String[] args)
    {
        AnotherRealSubject anotherRealSubject = new AnotherRealSubject();
    
        InvocationHandler invocationHandler = new DynamicSubject( anotherRealSubject );
    
        Class<?> clazz = invocationHandler.getClass();
    
        Subject subject = (Subject) Proxy.newProxyInstance( clazz.getClassLoader(), anotherRealSubject.getClass().getInterfaces(), invocationHandler );
        
        subject.doSomething();
    
        
    }
}
