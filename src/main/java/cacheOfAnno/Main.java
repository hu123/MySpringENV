package cacheOfAnno;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 这个例子说明了第一次从目的地查询数据,
 * 第二次从缓存中拿数据,@Cacheable标记的getAccountByName()根本不执行
 */
public class Main
{
    public static void main(String[] args)
    {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext( "classpath:spring/cache.xml" );
        AccountService s = applicationContext.getBean( "accountServiceBean", AccountService.class );
    
        System.out.println( "第一次查询" );
        Account account = s.getAccountByName( "someBody" );
    
        System.out.println( "第二次查询" );
        Account account1 = s.getAccountByName( "someBody" );
    
        
        System.out.println(account == account1);
        
    }
}
