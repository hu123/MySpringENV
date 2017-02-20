package org.cglibdemo;

public class UserServiceImpl
{
    
    private String string = null ;
    
    public String getString()
    {
        return string;
    }
    
    public void setString(String string)
    {
        this.string = string;
    }
    
    public  void add()
    {
        System.out.println( "这是add方法" );
    }
    
    public void delete()
    {
        System.out.println( "这是删除方法" );
    }
           
}
