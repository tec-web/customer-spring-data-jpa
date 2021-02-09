package com.tecweb.springdata.jpa.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.not;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tecweb.springdata.jpa.model.Customer;

@SpringBootTest
class CustomerServiceTestIT {
	@Autowired
	CustomerService customerService;
	
	@Test
	void givenACustomerWhenSaveItANewCustomerIsStoredIntoTheDatabase() {		
		Customer homer = new Customer();
		homer.setName("Homer Simpson");
		homer.setEmail("homer.simpson@somedomain.com");
		homer = customerService.save(homer);		
		assertNotNull(homer);
		assertThat(is(not(homer.getId())));				
	}
	
	@Test
	void givenAnEmailAddressWhenLookForItReturnsCustomerBelogsToIt() {
		final String EMAIL = "homer.simpson@somedomain.com";
		Optional<Customer> customer = customerService.findByEmail(EMAIL);
		Long id = customer.map(Customer::getId).orElse(0L);
		assertNotNull(customer);
		assertEquals("Homer Simpson", customer.get().getName());
		assertThat(is(id > 0));		
	}
}
