package com.furama.democustomer.service.customerType;

import com.furama.democustomer.model.CustomerType;

import java.util.List;

public interface ICustomerTypeService {
    List<CustomerType> showList();
    CustomerType findById(Long id);
}
