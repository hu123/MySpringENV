package staticProxyMode;

public class ProxySubject implements Subject
{
    private RealSubject realSubject;
    
    @Override
    public void doSomething()
    {
        this.preSomething();
        if(null == realSubject)
        {
            realSubject = new RealSubject();
        }
        realSubject.doSomething();
        
        this.postSomething();
        
    }
    public void preSomething()
    {
        System.out.println("之前");
    }
    
    public void postSomething()
    {
        System.out.println("之后");
    }
    
}
