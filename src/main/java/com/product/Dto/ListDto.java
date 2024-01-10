package com.product.Dto;

import com.product.Entity.Product;

import java.util.List;

public class ListDto {

    private List<Product> listPdt;
    private String message;


    public List<Product> getListPdt() {
        return listPdt;
    }

    public void setListPdt(List<Product> listPdt) {
        this.listPdt = listPdt;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
