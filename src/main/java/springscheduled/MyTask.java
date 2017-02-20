package springscheduled;


import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyTask
{
    @Autowired
    private SimpleDateFormat simpleDateFormat ;
    
    public void show()
    {
        System.out.println( "show方法当前时间:" + simpleDateFormat.format( new Date() ) );
        
    }
    
    public void print()
    {
        System.out.println( "print方法当前时间:" + simpleDateFormat.format( new Date() ) );
    }
    
}
