package com.oracle.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.oracle.model.Customer;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
public class CustomerDaoImpl implements CustomerDao{

	@PersistenceContext
	private EntityManager eniEntityManager;
	
	@Override
	@Transactional
	
	/*
	 
	 The @Transactional annotation marks a method (or class) 
	 so that all database operations inside it run within a single transaction, 
	 ensuring atomicity — either all succeed or all fail (rollback).
	 
	 */
	
	public void createCustomer(Customer cust) {
		eniEntityManager.persist(cust); //insert
	}

	
	@Override
	@Transactional
	public void updateCustomer(Customer cust) {
	    // `merge` updates the existing entity or inserts if not found
	    eniEntityManager.merge(cust);
	}
	
	@Override
	public Customer readCustomerByEmail(String email) {
		return eniEntityManager.find(Customer.class, email); //select by email
	}

	@Override
	public List<Customer> readAllCustomers() {
		String jpql = "SELECT c FROM Customer c";
		return eniEntityManager.createQuery(jpql,Customer.class).getResultList(); // select * from myCustomer
	}
	
	
	@Override
	@Transactional
	public void deleteCustomerByEmail(String email) {
	    Customer customer = eniEntityManager.find(Customer.class, email);
	    if (customer != null) {
	        eniEntityManager.remove(customer);
	    }
	}

}
