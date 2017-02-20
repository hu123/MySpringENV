package oldcache;

import cacheOfAnno.Account;

public class MyAccountService
{
    private MyCacheManager<Account> cacheManager;
    
    public MyAccountService()
    {
        // 构造一个缓存管理器
        cacheManager = new MyCacheManager<Account>();
    }
    
    public Account getAccountByName(String acctName)
    {
        // 首先查询缓存
        Account result = cacheManager.getValue( acctName );
        if(result != null)
        {
            System.out.println( "从缓存中拿的..." + acctName );
    
            // 如果在缓存中，则直接返回缓存的结果
            return result;
        }
    
        // 否则到数据库中查询
        result = getFromDB( acctName );
        // 将数据库查询的结果更新到缓存中
        if(result != null)
        {
            cacheManager.addOrUpdateCache( acctName, result );
        }
        return result;
    }
    
    public void reload()
    {
        cacheManager.evictCache();
    }
    
    private Account getFromDB(String acctName)
    {
        System.out.println( "从数据库中查询..." + acctName );
        return new Account( acctName );
    }
    
}
