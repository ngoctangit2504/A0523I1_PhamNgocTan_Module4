package com.furama.good.service.product;

import com.furama.good.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService {
    //     List<Customer> showList();
    Page<Product> findAll(Pageable pageable);

    void addNewProduct(Product product);

    void delete(Long id);

    Product updateProduct(Product updateProduct);

    Product findOne(Long id);
}
