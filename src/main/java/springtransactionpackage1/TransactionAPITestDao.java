package springtransactionpackage1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("myDao")
public class TransactionAPITestDao
{
    @Autowired
    private JdbcTemplate jdbcTemplate ;
    
    @Transactional(rollbackFor = {Exception.class})
    public void insertRecord() throws Exception
    {
        System.out.println("开始插入数据");
        jdbcTemplate.update( "insert into aaa values ('auto')" );
    
        
        System.out.println("结束插入数据");
        throw new Exception( "Dao的时候手动抛出异常" );
        
    }
    
}
