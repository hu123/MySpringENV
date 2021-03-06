package javax.cache.test;

import javax.cache.CacheManager;
import javax.cache.configuration.OptionalFeature;
import javax.cache.spi.CachingProvider;
import java.net.URI;
import java.util.Properties;

public class DefaultCachingProvider implements CachingProvider
{
    
    private CacheManager cacheManager = new DefaultCacheManager( this );
    
    @Override
    public CacheManager getCacheManager(URI uri, ClassLoader classLoader, Properties properties)
    {
        return cacheManager;
    }
    
    @Override
    public ClassLoader getDefaultClassLoader()
    {
        return null;
    }
    
    @Override
    public URI getDefaultURI()
    {
        return null;
    }
    
    @Override
    public Properties getDefaultProperties()
    {
        return null;
    }
    
    @Override
    public CacheManager getCacheManager(URI uri, ClassLoader classLoader)
    {
        return cacheManager;
    }
    
    @Override
    public CacheManager getCacheManager()
    {
        return cacheManager;
    }
    
    @Override
    public void close()
    {
        
    }
    
    @Override
    public void close(ClassLoader classLoader)
    {
        
    }
    
    @Override
    public void close(URI uri, ClassLoader classLoader)
    {
        
    }
    
    @Override
    public boolean isSupported(OptionalFeature optionalFeature)
    {
        return false;
    }
}
