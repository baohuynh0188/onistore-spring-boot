package com.spring.onistore.dto;

import java.util.ArrayList;
import java.util.List;

public class ProductCheckOutDto {

    private ProductCustomDto productCustomDto;

    private int amount;


    public ProductCheckOutDto() {
    }

    public ProductCheckOutDto(ProductCustomDto productCustomDto, int amount) {
        this.productCustomDto = productCustomDto;
        this.amount = amount;
    }

    public ProductCustomDto getProductCustomDto() {
        return productCustomDto;
    }

    public void setProductCustomDto(ProductCustomDto productCustomDto) {
        this.productCustomDto = productCustomDto;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
