package com.tecweb.springdata.jpa.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tecweb.springdata.jpa.model.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
	public Optional<Customer> findByEmail(String email);
}
