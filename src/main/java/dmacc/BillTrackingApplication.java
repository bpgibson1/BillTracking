package dmacc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import dmacc.beans.Bill;
import dmacc.controller.BeanConfiguration;
import dmacc.repository.BillRepository;

@SpringBootApplication
public class BillTrackingApplication {

	public static void main(String[] args) {
		SpringApplication.run(BillTrackingApplication.class, args);
	}
	
//	@Autowired
//	BillRepository repo;
//
//	public void run(String... args) throws Exception {
//		
//	ApplicationContext appContext = new AnnotationConfigApplicationContext(BeanConfiguration.class);
//	
//		List<Bill> allBills = repo.findAll();
//		//list all bills
//		for(Bill bills: allBills) {
//			System.out.println(bills.toString());
//		}
//		
//	((AbstractApplicationContext) appContext).close();
//	}
}
