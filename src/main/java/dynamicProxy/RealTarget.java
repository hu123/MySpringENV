package dynamicProxy;

public class RealTarget implements Target
{
    public void doTarget()
    {
        System.out.println("达到目标......");
    }
}
