package spring.i18ntest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.GregorianCalendar;
import java.util.Locale;

public class I18nTest
{
    public static void main(String[] args)
    {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext( "classpath:spring/i18n.xml" );
        Object[] params = { "zhangsan", new GregorianCalendar().getTime() };
        MessageSource messageSource = (MessageSource) applicationContext.getBean( "messageSource" );
        String string1 = messageSource.getMessage( "hello", params, Locale.CHINA );
        String string2 = messageSource.getMessage( "hello", params, Locale.US );
        System.out.println(string1);
        System.out.println(string2);
    }
}
