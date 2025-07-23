package com.oracle.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Component
@Scope(scopeName = "prototype")
@Entity // The `@Entity` annotation marks a Java class as a **JPA entity**, meaning it maps to a table in a relational database.

@Table(name = "myCustomer") // the name will be created as MY_CUSTOMER
public class Customer {
	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;
	
	@Id // Primary Key
	private String email;

	@Autowired
	@OneToOne(cascade = CascadeType.PERSIST)
	private Account acc; // Spring will inject a suitable Account bean here

	/*
	 When the parent entity (e.g., Customer) is saved to the database, 
	 the associated Account object (acc) will also be automatically persisted.
	 
	 This is useful to ensure both related records are saved in a single operation, 
	 without needing a separate persist(account) call.
	 */
	
	public Customer() {
		super();
		System.out.println("Customer created");
	}

	@Override
	public String toString() {
		return "Customer Details\n[firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]" + "\n"
				+ acc;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Account getAcc() {
		return acc;
	}

	public void setAcc(Account acc) {
		this.acc = acc;
	}

}
