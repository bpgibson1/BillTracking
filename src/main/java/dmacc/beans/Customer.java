package dmacc.beans;
//Added customer entity still working

import javax.persistence.Embeddable;

@Embeddable
public class Customer extends Person{
	
	private String contactNumber;
	
	public Customer() {
		super();
	}
	
	public Customer(String first, String last, String number) {
		super(first, last);
		this.contactNumber = number;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	
}
