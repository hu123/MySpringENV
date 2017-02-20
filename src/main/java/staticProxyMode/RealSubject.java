package staticProxyMode;

public class RealSubject implements Subject
{
    @Override
    public void doSomething()
    {
        System.out.println( "租房" );
    }
}
