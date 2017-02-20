package javax.cache.test;

import java.util.Date;

public abstract class MyFactory
{
    private static MyFactory myFactory = null;
    
    public abstract void sayHello();
    
    public static MyFactory getInstace()
    {
        if(myFactory == null)
        {
            return new MyFactory()
            {
                @Override
                public void sayHello()
                {
                    System.out.println( "你好么????" );
                }
            };
        }
        
        return myFactory;
    }
    
    public  Date getDate()
    {
        return new Date();
    }
    
    
}
