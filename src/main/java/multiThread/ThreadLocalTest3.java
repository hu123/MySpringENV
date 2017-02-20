package multiThread;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ThreadLocalTest3
{
    
    
    
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException
    {
    
        Class<?> clazz = ThreadLocal.class;
    
        Method method = clazz.getDeclaredMethod( "createMap", Thread.class ,Object.class );
    
        method.setAccessible( true );
        
        method.invoke( clazz.newInstance(), Thread.currentThread(), "helloworld" );
        
    }
}
