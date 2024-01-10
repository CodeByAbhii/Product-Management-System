package com.product.Services;

import com.product.Dto.ListDto;
import com.product.Dto.ProductDto;
import com.product.Dto.UpdateDto;
import com.product.Entity.Product;

import java.util.List;

public interface ProductService {

    public ProductDto saveProduct(ProductDto dto);


    public List<Product> getAllData();

    public  List<ListDto> getAllRecord();


    public void deleteById(long id);

    public Product updateRecord(long id , Product pdt);

    public Product updateRecord(Long id , Product pdt);

}
