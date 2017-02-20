package dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicSubject implements InvocationHandler
{
    /**
     * 被代理的那个对象,这里使用了Object,于是代码就有了普遍性...
     */
    private Object obj ;
    
    public DynamicSubject(Object obj)
    {
        this.obj = obj;
    }
    
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
    {
    
        System.out.println( "做某事之前" );
    
        method.invoke( obj, args );
        
        System.out.println( "做某事之后" );
        return null;
    }
}
