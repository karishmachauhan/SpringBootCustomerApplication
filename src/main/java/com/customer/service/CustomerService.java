package com.customer.service;

import java.util.List;

import com.customer.domain.Customer;

public interface CustomerService {

	List<Customer> getAllCustomers();
	long getCustomerCount();
	Customer createCustomer(Customer customer);
	Customer updateCustomer(String id, Customer customer);
	void deleteCustomer(String id);
}
