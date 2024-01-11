package com.product.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Products")
@Data
@AllArgsConstructor
@NoArgsConstructor


public class Product {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Size(min=3 , message = "Product Filed Atlest 3 or more later and Should be Not Empty")
    private String product;

    @Size(min = 4 ,  max= 8 , message = "price should more than 1000")
    private String price;

    @NotNull
    private String category;

    @NotNull
    @Size(min = 4 ,  max= 500 , message = "Description  should more than 10 word ")
    private  String description;




}
