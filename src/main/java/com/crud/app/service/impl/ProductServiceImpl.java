package com.crud.app.service.impl;

import com.crud.app.domain.entity.Product;
import com.crud.app.repository.ProductRepository;
import com.crud.app.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Product getById(UUID id) throws Exception {
        return productRepository.findById(id).orElseThrow(Exception::new);
    }

    @Override
    public Product create(Product productRequest) {
        return productRepository.save(productRequest);
    }

    @Override
    public Product update(UUID id, Product productRequest) throws Exception {
        Product product = getById(id);
        Product productToSave = new Product();
        BeanUtils.copyProperties(productRequest, productToSave);
        productToSave.setId(product.getId());
        return productRepository.save(productToSave);
    }

    @Override
    public Boolean delete(UUID id) throws Exception {
        Product product = getById(id);
        productRepository.delete(product);
        return Boolean.TRUE;
    }
}
