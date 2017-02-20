package bean;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/application.xml")
public class MyBeanTest
{
    @Autowired
    private ApplicationContext applicationContext;
    
    
    @Test
    public void name() throws Exception
    {
        /**
         * 拿到Spring容器中被Deprecated注解标记的对象
         */
        Map<String, Object> map = applicationContext.getBeansWithAnnotation( Deprecated.class );
        
        Set<Map.Entry<String, Object>> set = map.entrySet();
        
        System.out.println( "开始" );
        for(Iterator<Map.Entry<String, Object>> iterator = set.iterator(); iterator.hasNext();)
        {
            Map.Entry<String, Object> entry = iterator.next();
            System.out.println( entry.getKey() + ",-------------->" + entry.getValue() );
        } System.out.println( "结束" );
        
    }
}