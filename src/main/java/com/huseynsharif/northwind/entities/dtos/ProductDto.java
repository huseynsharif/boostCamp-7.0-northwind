package com.huseynsharif.northwind.entities.dtos;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductDto {

    @NotBlank
    @NotNull
    private String productName;


    private int categoryId;

    @NotBlank
    @NotNull
    private String quantityPerUnit;

    private int unitPrice;

}
