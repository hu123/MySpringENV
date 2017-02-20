package aop;

public class HelloWorldImpl1 implements HelloWorld
{
    public void printHelloWorld()
    {
        System.out.println( "进入 HelloWorldImpl1.printHelloWorld()" );
    }
    
    public void doPrint()
    {
        System.out.println( "进入HelloWorldImpl1.doPrint" );
    }
}
