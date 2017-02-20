package multiThread;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.CyclicBarrier;


class MyThread implements Runnable
{
    
    private CyclicBarrier cyclicBarrier;
    
    /**
     * 第一个线程所持有的ThreadLocalMap对象
     */
    static Object object1 = null;
    
    /**
     * 第二个线程所持有的ThreadLocalMap对象
     */
    static Object object2 = null;
    
    public MyThread(CyclicBarrier cyclicBarrier)
    {
        this.cyclicBarrier = cyclicBarrier;
    }
    
    @Override
    public void run()
    {
        ThreadLocal threadLocal = new ThreadLocal();
        
        Thread thread = Thread.currentThread();
        
        Class<?> clazz = ThreadLocal.class;
        
        Method createMap = null;
        
        try
        {
            Method[] methods = clazz.getDeclaredMethods();
            
            Method createMapMethod = null;
    
            /**
             * 通过反射拿到createMap方法的Method对象
             */
            for(Method method : methods)
            {
                if("createMap".equals( method.getName() ))
                {
                    createMapMethod = method;
                    
                }
            }
            
            System.out.println( createMapMethod );
            
            
            if(createMapMethod != null)
            {
                createMapMethod.setAccessible( true );
                createMapMethod.invoke( threadLocal, thread, "helloworld" );
            }
    
            /**
             * 通过执行getMap()方法拿到那个LocalThreadMap对象
             */
            Method getMap = clazz.getDeclaredMethod( "getMap", Thread.class );
            
            getMap.setAccessible( true );
            
            System.out.println( getMap.invoke( threadLocal, thread ) );
            
            if("thread1".equals( Thread.currentThread().getName() ))
            {
                object1 = getMap.invoke( threadLocal, thread );
            }
            if("thread2".equals( Thread.currentThread().getName() ))
            {
                object2 = getMap.invoke( threadLocal, thread );
            }
    
            /**
             * 等两个线程都先拿到那个ThreadLocalMap对象才开始执行CyclicBarrier构造方法里面的那个Runnable接口的匿名类里的run方法,
             * 由最后一个完成的线程执行。
             */
            cyclicBarrier.await();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        
    }
}

public class ThreadLocalTest
{
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, InterruptedException, NoSuchMethodException, InstantiationException, InvocationTargetException
    {
        CyclicBarrier cyclicBarrier = new CyclicBarrier( 2, new Runnable()
        {
            @Override
            public void run()
            {
                /**
                 * 判断两个线程对象内所持有的ThreadLocalMap是否为同一对象
                 */
                System.out.println(MyThread.object1 == MyThread.object2);
            }
        } );
    
        MyThread myThread = new MyThread( cyclicBarrier );
        
        Thread thread1 = new Thread( myThread, "thread1" );
        Thread thread2 = new Thread( myThread, "thread2" );
        thread1.start();
        thread2.start();
        
    }
}
