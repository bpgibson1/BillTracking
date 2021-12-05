/**
 * @author froda - ddgibson
 * CIS175 - Fall 2021
 * Nov 17, 2021
 */
package dmacc.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dmacc.beans.Bill;
import dmacc.beans.Customer;
import dmacc.beans.Employee;
import dmacc.beans.Person;

@Configuration
public class BeanConfiguration {

	
	@Bean
	public Bill bill() {
		Bill bean = new Bill();
		
		return bean;
	}
	
	@Bean
	public Employee employee() {
		Employee bean = new Employee();
		
		return bean;
	}
	
	@Bean
	public Customer customer() {
		Customer bean = new Customer();
		
		return bean;
	}
	
	@Bean
	public Person person() {
		Person bean = new Person();
		
		return bean;
	}
}
