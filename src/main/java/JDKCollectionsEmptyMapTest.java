import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JDKCollectionsEmptyMapTest
{
    public static void main(String[] args)
    {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext( "classpath:spring/application.xml" );
    
        Object obj1 = applicationContext.getBean( "aaa" );
        Object obj2 = applicationContext.getBean( "bbb" );
    
        System.out.println(obj1 == obj2);
        
        
        
    }
}
