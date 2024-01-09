package com.product.Services.Impl;

import com.product.Dto.ProductDto;
import com.product.Entity.Product;
import com.product.Services.ProductService;
import com.product.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

 private ProductRepository productRepo;

    public ProductServiceImpl(ProductRepository productRepo) {
        this.productRepo = productRepo;
    }

    @Override
    public ProductDto saveProduct(ProductDto dto) {
        
        Product pdt = new Product();
        
        pdt.setProduct(dto.getProduct());
        pdt.setCategory(dto.getCategory());
        pdt.setPrice(dto.getPrice());
        pdt.setDescription(dto.getDescription());

        Product save = productRepo.save(pdt);

        ProductDto pddto = new ProductDto();
        
        pddto.setProduct(save.getProduct());
        pddto.setCategory(save.getCategory());
        pddto.setPrice(save.getPrice());
        pddto.setDescription(save.getDescription());
        return pddto;
    }
}
