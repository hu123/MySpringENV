package generic;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Date;
import java.util.Vector;

public class GenericExc
{
    
    public static void main(String[] args) throws Exception
    {
        Method applyMethod = GenericExc.class.getMethod( "applyVector", Vector.class );
        //Type 是 Java 编程语言中所有类型的公共高级接口。它们包括原始类型、参数化类型、数组类型、类型变量和基本类型。
        Type[] types = applyMethod.getGenericParameterTypes();
        
        ParameterizedType pType = (ParameterizedType) types[0];//ParameterizedType是Type的子接口
        System.out.println( pType.getRawType() );//得到原始类型
        System.out.println( pType.getActualTypeArguments()[0] );//得到实际类型
        
        //applyVector(Vector v)时, java.lang.Class 
        //applyVector(Vector<Date> v) sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl
        System.out.println( types[0].getClass() );
        
        //jdk1.8以后有了简便的方法直接得到了 java.util.Vector<java.util.Date>
        System.out.println( types[0].getTypeName() );
    
        GenericExc genericExc = new GenericExc();
        applyMethod.invoke( genericExc, new Vector<Date>() );
        
    }
    
    public void applyVector(Vector<Date> v)
    {
        System.out.println("调用了....");
    }
    
}