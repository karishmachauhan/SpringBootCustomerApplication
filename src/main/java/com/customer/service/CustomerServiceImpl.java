package com.customer.service;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.UUID;
import java.util.HashMap;
import com.customer.exception.CustomerCustomException;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.customer.domain.Customer;

/**
 * 
 * @author karishmachauhan
 * Separated Business Logic from controller class
 */
@Service
public class CustomerServiceImpl implements CustomerService{
	
	private final Map<String, Customer> customers = new HashMap<>();

	public CustomerServiceImpl() {
		
	}
	
	@Override
	public List<Customer> getAllCustomers() {
        return new ArrayList<>(customers.values());
    }

	@Override
    public long getCustomerCount() {
        return customers.size();
    }

	@Override
    public Customer createCustomer(Customer customer) {
    	if (isExistingCustomer(customer)) {
            throw new CustomerCustomException(HttpStatus.BAD_REQUEST, "Customer already exists");
        }
        String id = UUID.randomUUID().toString();
        customer.setId(id);
        customers.put(id, customer);
        return customer;
    }
    
	@Override
    public Customer updateCustomer(String id, Customer customer) {
        Customer existingCustomer = customers.get(id);
        customer.setId(id);
        if (existingCustomer == null) {
            throw new CustomerCustomException(HttpStatus.NOT_FOUND, "Customer not found");
        }
        /* It is possible to check for duplicate email and phone number separately and 
         * throw even more customized exception but in real scenarios 
           in order to avoid security issues it is recommended to keep it as abstract as possible
        */
        if (isEmailOrCellNumberAlreadyUsed(customer)) {
        	throw new CustomerCustomException(HttpStatus.BAD_REQUEST, "Email or phone number already exists");
        }        
        customers.put(id, customer);
        return customer;
    }
	
	@Override
    public void deleteCustomer(String id) {
        Customer customer = customers.remove(id);
        /* Since error handling returns string message only and requirement is to send false
           with error message I added false in the string
        */
        if (customer == null) {
            throw new CustomerCustomException(HttpStatus.NOT_FOUND, "false: Customer not found");
        }
    }

    
    private boolean isExistingCustomer(Customer customer) {
        return customers.values().stream().anyMatch(c -> c.getEmail().equals(customer.getEmail())
                || c.getCellNumber().equals(customer.getCellNumber()));
    }

    private boolean isEmailOrCellNumberAlreadyUsed(Customer customer) {
        return customers.values().stream().anyMatch(c -> !c.getId().equals(customer.getId())
                && (c.getEmail().equals(customer.getEmail()) || c.getCellNumber().equals(customer.getCellNumber())));
    }

}
