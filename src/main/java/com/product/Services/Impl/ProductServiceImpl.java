package com.product.Services.Impl;

import com.product.Dto.ListDto;
import com.product.Dto.ProductDto;
import com.product.Dto.UpdateDto;
import com.product.Entity.Product;
import com.product.Services.ProductService;
import com.product.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<Product> getAllData() {

        List<Product> list = productRepo.findAll();

        ListDto dto = new ListDto();

        dto.setListPdt(dto.getListPdt());
        dto.setMessage("Reading is Completed!!");
        return list;
    }

    @Override
    public List<ListDto> getAllRecord() {
        List<Product> all = productRepo.findAll();
        ListDto dto = new ListDto();

        dto.setListPdt(all);
        dto.setMessage("Reading is Completed!!");
        return null;

    }

    @Override
    public void  deleteById(long id) {
       productRepo.deleteById(id);

    }

    @Override
    public Product updateRecord(long id, Product pdt) {
        Product product = productRepo.findById(id).get();

        product.setProduct(pdt.getProduct());
        product.setDescription(pdt.getDescription());
        product.setCategory(pdt.getCategory());
        product.setPrice(pdt.getPrice());

        Product save = productRepo.save(product);
        return save;
    }

    @Override
    public Product updateRecord(Long id, Product pdt) {
        Product product = productRepo.findById(id).get();
        return product;
    }


}
