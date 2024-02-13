package com.huseynsharif.northwind.entities.dtos;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductDto {

    private String productName;

    private int categoryId;

    private String quantityPerUnit;

    private int unitPrice;

}
