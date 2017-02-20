package dynamicProxy;

public class RealSubject implements Subject ,Subject2
{
    @Override
    public void doSomething()
    {
        System.out.println( "做某事....." );
    }
    
    @Override
    public void doSomething2()
    {
        System.out.println( "做某事2......" );
        
    }
    
    
    public void doSomething3(String name ,Integer integer )
    {
        System.out.println( "做某事3........" + name + integer );
        
    }
}
