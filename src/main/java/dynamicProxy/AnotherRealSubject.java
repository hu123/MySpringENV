package dynamicProxy;

public class AnotherRealSubject implements Subject
{
    @Override
    public void doSomething()
    {
        System.out.println( "另一个做某事" );
    }
}
