package springmvcpackage;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/spring-mvc.xml")
@WebAppConfiguration
public class MyControllerTest
{
    @Autowired
    private MyController myController ;
    
    @Test
    public void name() throws Exception
    {
        System.out.println("拿到的真实对象???:" + myController.getClass().getName());
        
    }
}