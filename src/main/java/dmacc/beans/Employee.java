/**
 * @author Bryner Gibson - bpgibson1
 * CIS175 - Fall 2021
 * Nov 16, 2021
 */
package dmacc.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Employee extends Person{
	@Id
	@GeneratedValue
	private long id;
	private int managerFlag;
	
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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getManagerFlag() {
		return managerFlag;
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
