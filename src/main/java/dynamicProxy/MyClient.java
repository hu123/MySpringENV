package dynamicProxy;

public class MyClient
{
    public static void main(String[] args)
    {
        RealTarget realTarget = new RealTarget();
    
        Target target = (Target) JDKProxy.getJDKProxyObject( realTarget );
        
        target.doTarget();
    }
}
