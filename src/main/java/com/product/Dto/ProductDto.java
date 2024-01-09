package com.product.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ProductDto {

    private  String product;
    private String  category;

    private String  price;
    private  String description;


}
