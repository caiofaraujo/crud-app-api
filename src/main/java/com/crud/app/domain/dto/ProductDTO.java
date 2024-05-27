package com.crud.app.domain.dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    UUID id;
    String title;
    String description;
    Double price;
}
