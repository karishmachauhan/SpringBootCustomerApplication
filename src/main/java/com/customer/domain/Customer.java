/**
 * 
 */
package com.customer.domain;

/**
 * @author karishmachauhan
 *
 */
public class Customer {
	
	    
	private String id;
	private String firstName;
	private String lastName;
	private String cellNumber;
	private String email;
	
	public Customer() {
       
}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		if (firstName == null || firstName.length() > 100) {
            throw new IllegalArgumentException("First name should be at most 100 characters long.");
        }
        this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		if (lastName == null || lastName.length() > 100) {
            throw new IllegalArgumentException("Last name should be at most 100 characters long.");
        }
		this.lastName = lastName;
	}

	public String getCellNumber() {
		return cellNumber;
	}

	public void setCellNumber(String cellNumber) {
		if (cellNumber == null || !cellNumber.matches("\\d{10}")) {
            throw new IllegalArgumentException("Cell number should be exactly 10 digits.");
        }
		this.cellNumber = cellNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		if (email == null || email.length() > 320) {
            throw new IllegalArgumentException("email should be at most 320 characters long.");
        }
		this.email = email;
	}


}
