package com.crud.app.controller;

import com.crud.app.model.Product;
import com.crud.app.service.ProductService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable UUID id) throws Exception {
        return ResponseEntity.ok().body(productService.getById(id));
    }

    @GetMapping("/list")
    public ResponseEntity<List<Product>> getAll(){
        return ResponseEntity.ok().body(productService.getAll());
    }

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody Product productRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.create(productRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable UUID id,
                                          @RequestBody Product productRequest) throws Exception {
        return ResponseEntity.ok().body(productService.update(id, productRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable UUID id) throws Exception {
        if(productService.delete(id)){
            return ResponseEntity.ok().body(Boolean.TRUE);
        }
        return ResponseEntity.ok().body(Boolean.FALSE);
    }
}
