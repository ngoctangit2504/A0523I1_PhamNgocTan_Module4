package com.furama.democustomer.service.customerType;

import com.furama.democustomer.model.CustomerType;
import com.furama.democustomer.repository.customerType.ICustomerTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerTypeService implements ICustomerTypeService{
    @Autowired
    private ICustomerTypeRepository iCustomerTypeRepository;

    @Override
    public List<CustomerType> showList() {
        return iCustomerTypeRepository.findAll();
    }

    @Override
    public CustomerType findById(Long id) {
        return iCustomerTypeRepository.findById(id).orElse(null);
    }
}
