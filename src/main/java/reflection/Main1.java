package reflection;

import java.lang.reflect.Method;

class User
{
    public void sayHello()
    {
        
    }
    
}

public class Main1
{
    public static void main(String[] args) throws Exception
    {
        Class<?> clazz = User.class;
        Method[] methods = clazz.getMethods();
    
        System.out.println(methods[0].getName());
    }
    
}
