package com.furama.democustomer.repository.customer;

import com.furama.democustomer.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepository extends JpaRepository<Customer, Long> {
}
