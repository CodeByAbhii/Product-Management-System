package com.product.Services.Impl;

import com.product.Dto.ListDto;
import com.product.Dto.ProductDto;
import com.product.Dto.UpdateDto;
import com.product.Entity.Product;
import com.product.Exception.ResourceNotFoundException;
import com.product.Services.ProductService;
import com.product.repository.ProductRepository;
import org.apache.logging.log4j.message.Message;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public Optional<Product> findById(long id) {
        Optional<Product> findById = productRepo.findById(id);
        if(findById.isPresent()){
            productRepo.deleteById(id);

        }else {
            throw new ResourceNotFoundException("ResourceNotFound With this Id : "+id);
        }
        return null;

    }

    @Override
    public ProductDto getProductById(long id) {
        Product product = productRepo.findById(id).orElseThrow(

                ()->new ResourceNotFoundException("Product Not Found with the Id :"+id)


        );
        ProductDto pddto = new ProductDto();

        pddto.setProduct(product.getProduct());
        pddto.setCategory(product.getCategory());
        pddto.setPrice(product.getPrice());
        pddto.setDescription(product.getDescription());
        return pddto;
    }


}
