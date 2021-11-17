/**
 * @author froda - ddgibson
 * CIS175 - Fall 2021
 * Nov 17, 2021
 */
package dmacc.controller;

import org.springframework.context.annotation.Bean;

import dmacc.beans.Bill;
import dmacc.beans.Employee;
import dmacc.beans.Person;

/**
 * @author froda
 *
 */
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
	public Person person() {
		Person bean = new Person();
		
		return bean;
	}
}
