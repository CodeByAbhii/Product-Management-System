package com.product.Controller;

import com.product.Dto.ProductDto;
import com.product.Services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// http://localhost8080/api/product
@RequestMapping("/api/product")
@RestController
public class ProductController {


    private ProductService pdtService;

    public ProductController(ProductService pdtService) {
        this.pdtService = pdtService;
    }

    @PostMapping

    public ResponseEntity<?>saveProduct(@RequestBody ProductDto pdto){

        ProductDto dto = pdtService.saveProduct(pdto);

              return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

}
