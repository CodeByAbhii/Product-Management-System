package com.product.Services;

import com.product.Dto.ListDto;
import com.product.Dto.ProductDto;
import com.product.Entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    public ProductDto saveProduct(ProductDto dto);


    public List<Product> getAllData();

    public  List<ListDto> getAllRecord();


    public void deleteById(long id);

    public Product updateRecord(long id , Product pdt);


  public Optional<Product> findById(long id);
}
