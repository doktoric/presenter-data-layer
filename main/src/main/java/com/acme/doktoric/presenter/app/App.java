package com.acme.doktoric.presenter.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Hello world!
 *
 */

@Component
public class App 
{
	
	
	
    public static void main( String[] args )
    {
    	System.out.println("Hello World!");
		ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/spring/main-applicationContext-spring.xml");
		
		
		
		
		
		
		System.out.println("hello vege");
    }
}
