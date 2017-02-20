package springtransactionpackage1;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("myService")
public class TransactionalAnnotation
{
    @Resource(name = "myDao")
    private TransactionAPITestDao myDao ;
    
//    @Transactional(rollbackFor = {RuntimeException.class})
//    public void insert()
//    {
//        myDao.insertRecord();
//        throw new RuntimeException( "故意手动抛异常....." );
            
//    }
    
}
