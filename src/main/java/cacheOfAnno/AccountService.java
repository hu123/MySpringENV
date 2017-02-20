package cacheOfAnno;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

public class AccountService
{
    /**
     * 使用了名称为accountCache的缓存
     */
    @Cacheable(value = "accountCache")
    public Account getAccountByName(String username)
    {
        System.out.println( "查询账户" + username );
        return getFromDB( username );
    }
    
    /**
     * 根据account的名字更新缓存
     */
    @CacheEvict( value = "accountCache",key = "#account.getName()")
    public void updateAccount(Account account)
    {
        updateDB( account );
    }
    
    
    /**
     * 清空accountCache缓存
     */
    @CacheEvict(value = "accountCache", allEntries = true)
    public void reload()
    {
        
    }
    
    private Account getFromDB(String acctName)
    {
        System.out.println( "查询db!!!!!!!!!!!!!!!!!!!!!!!!!!" + acctName );
        return new Account( acctName );
    }
    
    
    private void updateDB(Account account)
    {
        System.out.println( "更新数据库" + account.getName() );
    }
}
