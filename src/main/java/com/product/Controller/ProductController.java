package com.product.Controller;

import com.product.Dto.ListDto;
import com.product.Dto.ProductDto;
import com.product.Entity.Product;
import com.product.Exception.ResourceNotFoundException;
import com.product.Services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @DeleteMapping("/{id}")
    public ResponseEntity<?>deleteById(@PathVariable long id){
    Optional<Product> findById = pdtService.findById(id);
    if(findById.isPresent()){
        pdtService.deleteById(id);
        return new ResponseEntity<>("Record is deleted!!" , HttpStatus.INTERNAL_SERVER_ERROR);
    }else {
        throw new ResourceNotFoundException("ResourceNotFound With this Id : "+id);
    }

    }

    @PutMapping
    public ResponseEntity<?>updateRecord(@RequestParam long id , @RequestBody Product pdt){
        Product product = pdtService.updateRecord(id, pdt);
        return  new ResponseEntity<>(product , HttpStatus.CREATED);
    }

    @GetMapping
    public  ResponseEntity<ListDto>getAllData(){
        List<Product> list = pdtService.getAllData();
        ListDto dto = new ListDto();

        dto.setListPdt(list);
        dto.setMessage("Reading is Completed!!");
        return  new ResponseEntity<>(dto , HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
