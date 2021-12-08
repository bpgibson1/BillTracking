/**
 * @author Bryner Gibson - bpgibson1
 * CIS175 - Fall 2021
 * Nov 16, 2021
 */
package dmacc.beans;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
public class Bill {

	@Id
	@GeneratedValue
	private long id;
	private int total;
	private float tax;
	private String description;
	private String activity;
	//private Customer customer; customer will inherit from person
	//date variable *** look at input page for further guidance on variable name ***

	private int paid = 0;
	private int managerApprovalFlag = 0;

	@Autowired
	private Customer customer;
	// date variable *** look at input page for further guidance on variable name
	// ***

	@ManyToOne(fetch = FetchType.LAZY)
	private Employee employee;
	

	// TODO: constructors
	
	
	public Bill(long id, int total, float tax, String description, String activity) {
		super();
		this.id = id;
		this.total = total;
		this.tax = tax;
		this.description = description;
		this.activity = activity;
	}

	public Bill(int total, float tax, String description, String activity) {
		super();
		this.total = total;
		this.tax = tax;
		this.description = description;
		this.activity = activity;
	}

	public Bill(int total, float tax) {
		super();
		this.total = total;
		this.tax = tax;
		this.paid = 0;
	}

	public Bill(int total) {
		this.total = total;
	}

	public Bill() {
		super();
	}
	

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public float getTax() {
		return tax;
	}

	public void setTax(float tax) {
		this.tax = tax;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPaid() {
		return paid;
	}

	public void setPaid(int paid) {
		this.paid = paid;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public int getManagerApprovalFlag() {
		return managerApprovalFlag;
	}

	public void setManagerApprovalFlag() {
		if(this.total > 100) {
			this.managerApprovalFlag = 1;
		}
		else {
			this.managerApprovalFlag = 0;
		}
	}
	
	public void setManagerApproved() {
		this.managerApprovalFlag = 0;
	}
}
