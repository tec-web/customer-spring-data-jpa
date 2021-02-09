package com.tecweb.springdata.jpa.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tecweb.springdata.jpa.model.Customer;
import com.tecweb.springdata.jpa.repository.CustomerRepository;

@Service
public class CustomerService {
	private CustomerRepository customerRepository;
	
	public CustomerService(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	public Customer save(Customer customer) {
		return customerRepository.save(customer);
	}
	
	public Optional<Customer> findById(Long id){
		return customerRepository.findById(id);
	}
	
	public Optional<Customer> findByEmail(String email){
		return customerRepository.findByEmail(email);
	}
	
	public void deleteAll() {
		customerRepository.deleteAll();
	}
}
