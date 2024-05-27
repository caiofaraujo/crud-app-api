package com.crud.app.controller;

import com.crud.app.domain.dto.ProductDTO;
import com.crud.app.domain.entity.Product;
import com.crud.app.domain.mapper.ProductMapper;
import com.crud.app.service.ProductService;
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

    @CrossOrigin
    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getById(@PathVariable UUID id) throws Exception {
        return ResponseEntity.ok().body(ProductMapper.INSTANCE.toDto(productService.getById(id)));
    }

    @CrossOrigin
    @GetMapping("/list")
    public ResponseEntity<List<ProductDTO>> getAll(){
        return ResponseEntity.ok().body(ProductMapper.INSTANCE.toDto(productService.getAll()));
    }

    @CrossOrigin
    @PostMapping
    public ResponseEntity<ProductDTO> create(@RequestBody Product productRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(ProductMapper.INSTANCE.toDto(productService
                .create(productRequest)));
    }

    @CrossOrigin
    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> update(@PathVariable UUID id,
                                             @RequestBody Product productRequest) throws Exception {
        return ResponseEntity.ok().body(ProductMapper.INSTANCE.toDto(productService.update(id, productRequest)));
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable UUID id) throws Exception {
        if(productService.delete(id)){
            return ResponseEntity.ok().body(Boolean.TRUE);
        }
        return ResponseEntity.ok().body(Boolean.FALSE);
    }
}
