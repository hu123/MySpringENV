package springtransactionpackage1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/application.xml")
public class TransactionalAnnotationTest
{
    @Resource
    private TransactionAPITestDao transactionAPITestDao;
    
    
    @Test
    public void name() throws Exception
    {
        transactionAPITestDao.insertRecord();
        
    }
}