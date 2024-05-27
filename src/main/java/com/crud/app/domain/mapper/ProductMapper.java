package com.crud.app.domain.mapper;

import com.crud.app.domain.dto.ProductDTO;
import com.crud.app.domain.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    Product toModel(ProductDTO productDTO);
    ProductDTO toDto(Product product);
    List<ProductDTO> toDto(List<Product> productList);
}
