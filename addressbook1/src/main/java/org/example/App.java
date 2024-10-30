package org.example;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args ) throws BeansException {

       ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
       Book b1 = (Book) context.getBean("book");
       System.out.println(b1.getIsbn());
    }
}
