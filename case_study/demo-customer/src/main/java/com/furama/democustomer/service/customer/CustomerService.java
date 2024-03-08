package com.furama.democustomer.service.customer;

import com.furama.democustomer.model.Customer;
import com.furama.democustomer.repository.customer.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerSrvice{
    @Autowired
    private ICustomerRepository iCustomerRepository;


//    @Override
//    public List<Customer> showList() {
//        return iCustomerRepository.findAll();
//    }

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return iCustomerRepository.findAll(pageable);
    }

    @Override
    public void addNewCustomer(Customer customer) {
        iCustomerRepository.save(customer);
    }

    @Override
    public void delete(Long id) {
        iCustomerRepository.deleteById(id);
    }

    @Override
    public Customer findOne(Long id) {
        return iCustomerRepository.findById(id).get();
    }
}
