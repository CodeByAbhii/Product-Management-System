package com.product.Entity;

import jakarta.persistence.*;
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
    private String product;
    private String price;
    private String category;
    private  String description;




}
