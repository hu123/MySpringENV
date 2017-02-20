package springscheduled;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MyTestServiceImpl implements MyTestService
{
//    @Scheduled(cron="0/5 * *  * * ? ")   //每5秒执行一次
    @Scheduled(fixedRate = 2000)
    @Override
    public void myTest()
    {
        System.out.println("这个居然可以执行到????????");
    }
    
    
    public static void main(String[] args)
    {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext( "spring/scheduled.xml" );
        
        
    }
}
