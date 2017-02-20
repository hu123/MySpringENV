package javax.cache.test;

import javax.cache.Cache;
import javax.cache.CacheManager;
import javax.cache.configuration.Configuration;
import javax.cache.spi.CachingProvider;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class DefaultCacheManager implements CacheManager
{
    private CachingProvider cachingProvider;
    private Map<String, Cache> cacheMap = new HashMap<String, Cache>();
    
    public DefaultCacheManager(CachingProvider cachingProvider)
    {
        this.cachingProvider = cachingProvider;
    }
    
    public CachingProvider getCachingProvider()
    {
        return cachingProvider;
    }
    
    @Override
    public URI getURI()
    {
        return null;
    }
    
    @Override
    public ClassLoader getClassLoader()
    {
        return null;
    }
    
    @Override
    public Properties getProperties()
    {
        return null;
    }
    
    public <K, V, C extends Configuration<K, V>> Cache<K, V> createCache(String cacheName, C configuration) throws IllegalArgumentException
    {
        Cache cache = new DefaultCache( cacheName, this );
        cacheMap.put( cacheName, cache );
        
        return cache;
    }
    
    @Override
    public <K, V> Cache<K, V> getCache(String cacheName, Class<K> keyType, Class<V> valueType)
    {
        return null;
    }
    
    public <K, V> Cache<K, V> getCache(String cacheName)
    {
        return this.getCache( cacheName, null, null );
    }
    
    public Iterable<String> getCacheNames()
    {
        return cacheMap.keySet();
    }
    
    @Override
    public void destroyCache(String cacheName)
    {
        
    }
    
    @Override
    public void enableManagement(String cacheName, boolean enabled)
    {
        
    }
    
    @Override
    public void enableStatistics(String cacheName, boolean enabled)
    {
        
    }
    
    @Override
    public void close()
    {
        
    }
    
    @Override
    public boolean isClosed()
    {
        return false;
    }
    
    @Override
    public <T> T unwrap(Class<T> clazz)
    {
        return null;
    }
    
    
}
