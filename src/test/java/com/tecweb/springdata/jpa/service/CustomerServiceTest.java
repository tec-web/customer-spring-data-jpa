package com.tecweb.springdata.jpa.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import com.tecweb.springdata.jpa.model.Customer;
import com.tecweb.springdata.jpa.repository.CustomerRepository;

@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {
	@Autowired
	CustomerService customerService;

	@Mock
	CustomerRepository customerRepository;	
	
	@BeforeEach
	public void init() {
		customerService = new CustomerService(customerRepository);
		Customer homer = new Customer();
		homer.setName("Homer Simpson");
		homer.setEmail("homer.simpson@somedomain.com");
		Optional<Customer> optCustomer = Optional.of(homer);
		Mockito.when(customerRepository.findByEmail(Mockito.anyString())).thenReturn(optCustomer);
	}

	@Test
	public void givenAValidCustomerName_whenLookingForIt_thenCustomerMustBeFound() {
		final String CUSTOMER_NAME = "Homer Simpson";
		Optional<Customer> response = customerService.findByEmail(CUSTOMER_NAME);
		assertTrue(response.isPresent());
		assertEquals(CUSTOMER_NAME, response.get().getName());	
	}
}
