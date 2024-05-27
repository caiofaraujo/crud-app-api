package com.crud.app.service;

import com.crud.app.domain.entity.Product;
import java.util.List;
import java.util.UUID;

public interface ProductService {
    List<Product> getAll();
    Product getById(UUID id) throws Exception;
    Product create(Product productRequest);
    Product update(UUID id, Product productRequest) throws Exception;
    Boolean delete(UUID id) throws Exception;
}
