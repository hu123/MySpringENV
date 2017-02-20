package dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKProxy
{
    public static Object getJDKProxyObject(final Object object)
    {
        InvocationHandler invocationHandler = new InvocationHandler()
        {
            
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
            {
                System.out.println( "动态代理之前" );
    
                method.invoke( object, args );
                
                System.out.println( "动态代理之后" );
                
                return null;
            }
        };
    
        Target target = (Target) Proxy.newProxyInstance( invocationHandler.getClass().getClassLoader(), object.getClass().getInterfaces(), invocationHandler );
        
        
        return target;
        
        
    }
}
