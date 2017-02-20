package dynamicProxy;

import org.junit.Test;

/**
 * 生成代理类的class文件到硬盘上,以便于反编译......
 */
public class ProxyGeneratorUtilsTest
{
    @Test
    public void testProxy() throws Exception
    {
        ProxyGeneratorUtils.writeProxyClassToHardDisk( "E:/$Proxy1.class" );
        
    }
    
}