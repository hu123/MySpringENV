package springscheduled;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.SimpleDateFormat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/scheduled.xml")
public class MyTaskTest
{
    @Autowired
    private SimpleDateFormat simpleDateFormat;
    
    @Test
    public void name() throws Exception
    {
//        System.out.println("当前时间是:" + simpleDateFormat.format( new Date() ));
        
    }
}