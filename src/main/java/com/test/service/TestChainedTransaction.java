package com.test.service;

import javax.xml.bind.JAXBException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;





public class TestChainedTransaction {
	
	public static void main(String[] args) throws InterruptedException {

		  ApplicationContext context = new ClassPathXmlApplicationContext("com/test/config/app-context.xml");

		  ProductService service = (ProductService) context.getBean("myProductServiceTarget");
		  //Placing an Order which have database operations for two different DB's
		  service.placeOrder();

	}

}
