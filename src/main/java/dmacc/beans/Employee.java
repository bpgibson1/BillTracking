/**
 * @author Bryner Gibson - bpgibson1
 * CIS175 - Fall 2021
 * Nov 16, 2021
 */
package dmacc.beans;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Employee extends Person{
	@Id
	@GeneratedValue
	private long id;
	private int managerFlag;
	
	@OneToMany(mappedBy = "employee", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Bill> bills;
	
	private String userName;
	
	private String password;
	
	public Employee() {
		super();
	}

	// default to only an employee
	public Employee(String firstName, String lastName) {
		super(firstName, lastName);
		this.managerFlag = 0;
	}

	public Employee(String firstName, String lastName, int managerFlag) {
		super(firstName, lastName);
		this.setManagerFlag(managerFlag);
	}

	public Employee(long id, String firstName, String lastName, int managerFlag) {
		super(firstName, lastName);
		this.id = id;
		this.setManagerFlag(managerFlag);
	}
	
	public void addBill(Bill bill) {
		this.bills.add(bill);
		bill.setEmployee(this);
	}
	
	public void removeBill(Bill bill) {
		this.bills.remove(bill);
		bill.setEmployee(null);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getManagerFlag() {
		return managerFlag;
	}
	

	public List<Bill> getBills() {
		return bills;
	}

	public void setBills(List<Bill> bills) {
		this.bills = bills;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setManagerFlag(int managerFlag) {
		// if bad info passes in set the flag to employee
		// 1 == manager
		// 0 == employee
		if (managerFlag < 0 || managerFlag > 1) {
			this.managerFlag = 0;
		}
		else {
			this.managerFlag = managerFlag;
		}
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + super.getFirstName() + ", lastName=" + super.getLastName() + ", managerFlag="
				+ managerFlag + "]";
	}
		
}
