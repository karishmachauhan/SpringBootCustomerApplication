/**
 * 
 */
package com.customer.controller;
import java.util.List;
import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import com.customer.domain.Customer;
import com.customer.service.CustomerServiceImpl;
import com.customer.exception.CustomerCustomException;

/**
 * @author karishmachauhan
 *
 */
@RestController
@RequestMapping("/customers")
public class CustomerController {
	@Autowired
	private CustomerServiceImpl customerService;
	

    @GetMapping
    public List<Customer> getCustomers() {
    	       
        return customerService.getAllCustomers();
    }

    @GetMapping("/count")
    public long countCustomers() {
        
        return customerService.getCustomerCount();
    }

    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        Customer createdCustomer = customerService.createCustomer(customer);
        return ResponseEntity.created(URI.create("/customers/" + createdCustomer.getId())).body(createdCustomer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable String id, @RequestBody Customer customer) {
        Customer updatedCustomer = customerService.updateCustomer(id, customer);
        return ResponseEntity.ok(updatedCustomer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteCustomer(@PathVariable String id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.ok(true);
    }
    
    @ExceptionHandler({CustomerCustomException.class})
    public ResponseEntity<String> handleBadRequest(CustomerCustomException e) {
    	return ResponseEntity.status(e.getHttpStatus()).body(e.getMessage());
    	
    }
    
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleRuntimeException(RuntimeException ex) {
		return ResponseEntity.internalServerError().body(ex.getMessage());

    }

    
}
