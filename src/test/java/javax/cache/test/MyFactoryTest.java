package javax.cache.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.cache.Cache;
import javax.cache.CacheManager;
import javax.cache.configuration.Configuration;
import javax.cache.spi.CachingProvider;
import java.util.Iterator;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/cache.xml")
public class MyFactoryTest
{
    private static Logger logger = LoggerFactory.getLogger( MyFactoryTest.class );
    
    @Autowired
    private CachingProvider cachingProvider;
    
    @Autowired
    private CacheManager cacheManager;
    
    @Test
    public void name() throws Exception
    {
        cacheManager.createCache( "myCache1", new Configuration<Object, Object>()
        {
            @Override
            public Class<Object> getKeyType()
            {
                return null;
            }
            
            @Override
            public Class<Object> getValueType()
            {
                return null;
            }
            
            @Override
            public boolean isStoreByValue()
            {
                return false;
            }
    
            @Override
            public int hashCode()
            {
                return super.hashCode();
            }
    
    
            @Override
            public boolean equals(Object obj)
            {
                return super.equals( obj );
            }
        } );
    
    
        Cache cache = null;
        
        
    }
}