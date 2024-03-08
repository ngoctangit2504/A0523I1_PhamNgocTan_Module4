package com.furama.democustomer.repository.customerType;

import com.furama.democustomer.model.CustomerType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerTypeRepository extends JpaRepository<CustomerType, Long> {
}
