package classLoaderTest;

import java.io.*;

class LoadedClass
{
    public void sayHello()
    {
        System.out.println( "你好世界" );
    }
}


public class ClassLoaderTest
{
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, IOException
    {
        
        
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        
        Class<LoadedClass> clazz = (Class<LoadedClass>) classLoader.loadClass( "classLoaderTest.LoadedClass" );
        
        LoadedClass loadedClass = clazz.newInstance();
        loadedClass.sayHello();
        
        InputStream inputStream = classLoader.getResourceAsStream( "spring/ctx-common-cache.xml" );
        
        InputStreamReader inputStreamReader = new InputStreamReader( inputStream );
    
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter( new FileOutputStream( "D:/ttt.txt" ) );
        
        char[] buffer = new char[1024];
        int length = 0;
        int start = 0;
        while(( length = inputStreamReader.read( buffer, start, buffer.length ) ) != -1)
        {
            outputStreamWriter.write( buffer, 0, length );
        }
    
        outputStreamWriter.flush();
    }
}
