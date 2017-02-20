package dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import java.util.Vector;

public class VectorProxy implements InvocationHandler
{
    private Object obj ;
    
    public VectorProxy(Object obj)
    {
        this.obj = obj;
    }
    
    
    /**
     * 拿到Vector对象的代理对象
     */
    public static Object factory(Object object)
    {
        Class<?> clazz = object.getClass();
    
        return Proxy.newProxyInstance( clazz.getClassLoader(), object.getClass().getInterfaces(), new VectorProxy( object ) );
    }
    
    
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
    {
        System.out.println("List的调用方法之前");
        
        
        Object value  = method.invoke( obj, args );
        System.out.println("List的调用方法之后");
    
        return value;
    }
    
    public static void main(String[] args)
    {
        List list = (List) factory( new Vector() );
        list.add( "想你的夜" );
        System.out.println(list);
    }
}
