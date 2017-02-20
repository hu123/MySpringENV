package testngspring;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import java.util.Date;

/**
 * 用于TestNG和spring做集成,
 * 类似于Junit的  @RunWith(SpringJUnit4ClassRunner.class)
 */
@ContextConfiguration(locations = "classpath:/spring/testngspring.xml")
public class TestNGSpringTest extends AbstractTestNGSpringContextTests
{
    @Autowired
    private Date date;
    
    
    @Test
    public void testName() throws Exception
    {
        System.out.println( "从Spring容器中拿到的date对象是" + date.toLocaleString() );
    }
}
