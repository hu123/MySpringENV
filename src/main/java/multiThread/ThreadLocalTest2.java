package multiThread;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;


class ReflectionTest<T, K>
{
    public Map<String, Object> map;
    
    public void sayHello(T t)
    {
        
    }
    
    
    public void sayHello(T t, K k)
    {
        
    }
}

public class ThreadLocalTest2
{
    public static void main(String[] args) throws NoSuchMethodException, NoSuchFieldException
    {
        
        Class<?> clazz = ReflectionTest.class;
        
        //        Method method = clazz.getMethod( "sayHello" );
        //        System.out.println(method);
        
        Field field = clazz.getDeclaredField( "map" );
        
        System.out.println( field );
        
        Type type = field.getGenericType();
        System.out.println( type );
        
        ParameterizedType parameterizedType = (ParameterizedType) type;
        
        Type[] types = parameterizedType.getActualTypeArguments();
        
        for(Type temp : types)
        {
            System.out.println(temp);
        }
    }
}
