package com.furama.democustomer.service.customer;

import com.furama.democustomer.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerSrvice {
    //     List<Customer> showList();
    Page<Customer> findAll(Pageable pageable);

    void addNewCustomer(Customer customer);

    void delete(Long id);

    Customer updateCustomer(Customer updateCustomer);

    Customer findOne(Long id);
}
