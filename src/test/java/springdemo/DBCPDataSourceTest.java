package springdemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

@EnableTransactionManagement
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/application.xml")
public class DBCPDataSourceTest
{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Test
    public void name() throws Exception
    {
        this.springTransactionalAnnotationTest();
    }
    
    @Transactional(rollbackFor = { DataAccessException.class})
    public void  springTransactionalAnnotationTest()
    {
        jdbcTemplate.update( "insert into aaa values ('hello')" );
    
        
        /**
         * 超出长度要求
         */
        jdbcTemplate.update( "insert into aaa values ('aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa')" );
        
    }
    
    
    
    /*
    
    @Autowired
    DataSource dataSource;
    
    private Connection connection;
    
    @Test
    public void name() throws Exception
    {
        System.out.println("拿到数据源对象了?????" + dataSource.getConnection());
        
//        connection = dataSource.getConnection();
//        PreparedStatement preparedStatement = connection.prepareStatement( "create table allMethod(name varchar(10)) " );
//        preparedStatement.execute();
        
        this.springTransactionalAnnotationTest();
//        this.connection.commit();
        
    }
    
    
    @Transactional
    public  void springTransactionalAnnotationTest() throws SQLException
    {
        connection = dataSource.getConnection();
//        connection.setAutoCommit( false );
        
        PreparedStatement preparedStatement = connection.prepareStatement( "insert into allMethod values (?)" );
        preparedStatement.setString( 1, "呵呵呵" );
        preparedStatement.execute();
        preparedStatement.setString( 1, "呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵" );
        preparedStatement.execute();
    }
    
    */
    
    
    
    
}
