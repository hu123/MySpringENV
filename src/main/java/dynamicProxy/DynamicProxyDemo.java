package dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 契约接口
 */
interface Goal
{
    void doSomething();
}

/**
 * 被代理的类
 */
class RealGoal implements Goal
{
    @Override
    public void doSomething()
    {
        System.out.println( "做某事......" );
    }
}

public class DynamicProxyDemo implements InvocationHandler
{
    /**
     * 被代理的对象
     */
    private RealGoal realGoal ;
    
    public DynamicProxyDemo(RealGoal realGoal)
    {
        this.realGoal = realGoal;
    }
    
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
    {
        /**
         * 做真正的目的时,我们可以在之前或之后加入一点我们的代理类想要做的事情
         */
        System.out.println("做某事之前");
        realGoal.doSomething();
        System.out.println("做某事之后");
    
        return null;
    }
    
    
    public static void main(String[] args)
    {
        /**
         * new 一个被代理的对象
         */
        RealGoal myRealGoal = new RealGoal();
    
        Class<?> clazz = myRealGoal.getClass();
    
        /**
         * 得到代理对象(以前笔者都认为拿到的是真实的目标对象,其实不是,这里拿到的是代理对象,而且是java在我们运行时给我们定义好的类相当于 public class  $Proxy0定义了$Proxy0这么一个类 )
         * $Proxy0这个类继承了  java.lang.reflect.Proxy,并且实现了被代理类所实现的所有接口.
         * 从newProxyInstance()方法第二个参数中我们可以看出来。
         */
        Goal goal = (Goal) Proxy.newProxyInstance( clazz.getClassLoader(), clazz.getInterfaces(), new DynamicProxyDemo( myRealGoal ) );
    
        goal.doSomething();
    
    }
    
}
