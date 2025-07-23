package com.oracle.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oracle.dao.CustomerDao;
import com.oracle.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerDao;

	@Override
	public void addCustomer(Customer cust) {
		customerDao.createCustomer(cust);
	}

	@Override
	public Customer findCustomerByEmail(String email) {
		return customerDao.readCustomerByEmail(email);
	}

	@Override
	public List<Customer> findAllCustomers() {
		return customerDao.readAllCustomers();
	}

	@Override
	public void updateCustomer(Customer cust) {
		customerDao.updateCustomer(cust);
	}

	@Override
	public void deleteCustomerByEmail(String email) {
		customerDao.deleteCustomerByEmail(email);
	}
}
