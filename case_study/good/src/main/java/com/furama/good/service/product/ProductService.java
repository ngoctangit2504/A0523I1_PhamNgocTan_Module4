package com.furama.good.service.product;

import com.furama.good.model.Product;
import com.furama.good.repository.product.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService{
    @Autowired
    private IProductRepository iProductRepository;
    @Override
    public Page<Product> findAll(Pageable pageable) {
        return iProductRepository.findAll(pageable);
    }

    @Override
    public void addNewProduct(Product product) {
        iProductRepository.save(product);
    }

    @Override
    public void delete(Long id) {
        iProductRepository.deleteById(id);
    }

    @Override
    public Product updateProduct(Product updateProduct) {
        return iProductRepository.save(updateProduct);
    }

    @Override
    public Product findOne(Long id) {
        return iProductRepository.findById(id).orElse(null);
    }
}
