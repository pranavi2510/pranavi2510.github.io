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
//        System.out.println(b1.getIsbn());
//        System.out.println(b1.getAuthor());
//
//        b1.setAuthor("Pranavi D");
        System.out.println(b1);

//        Book b2 = (Book) context.getBean("book");
//        System.out.println(b2);
//
//        b2.setAuthor("Naveena");
//        System.out.println(b2);
//        System.out.println("Now b1 is: ");
//        System.out.println(b1);
    }
}