package cacheOfAnno;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 更新缓存和清空所有缓存
 */
public class Main1
{
    public static void main(String[] args)
    {
        ApplicationContext context = new ClassPathXmlApplicationContext( "spring/cache.xml" );// 加载 spring 配置文件
        
        AccountService s = (AccountService) context.getBean( "accountServiceBean" );
        
        
        System.out.println( "开始测试清空缓存" );    // 更新某个记录的缓存，首先构造两个账号记录，然后记录到缓存中
        Account account1 = s.getAccountByName( "somebody1" );
        Account account2 = s.getAccountByName( "somebody2" );
        // 开始更新其中一个
        account1.setId( 1212 );
        s.updateAccount( account1 );
        s.getAccountByName( "somebody1" );// 因为被更新了，所以会查询数据库
        s.getAccountByName( "somebody2" );// 没有更新过，应该走缓存
        s.getAccountByName( "somebody1" );// 再次查询，应该走缓存
        // 更新所有缓存
        s.reload();
        s.getAccountByName( "somebody1" );// 应该会查询数据库
        s.getAccountByName( "somebody2" );// 应该会查询数据库
        s.getAccountByName( "somebody1" );// 应该走缓存
        s.getAccountByName( "somebody2" );// 应该走缓存
        
        
    }
}
