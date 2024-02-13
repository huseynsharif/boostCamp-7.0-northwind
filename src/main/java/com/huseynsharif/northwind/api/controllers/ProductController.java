package com.huseynsharif.northwind.api.controllers;

import com.huseynsharif.northwind.business.abstracts.ProductService;
import com.huseynsharif.northwind.core.utilities.results.DataResult;
import com.huseynsharif.northwind.core.utilities.results.Result;
import com.huseynsharif.northwind.entities.Product;
import com.huseynsharif.northwind.entities.dtos.ProductDto;
import com.huseynsharif.northwind.entities.dtos.ProductWithCategoryDetails;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
public class ProductController {

    private ProductService productService;

    @GetMapping("/getAll")
    public DataResult<List<Product>> getAll(){
        return this.productService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody ProductDto productDto){
        return this.productService.add(productDto);
    }

    @GetMapping("/find-by-product-name")
    public DataResult<ProductWithCategoryDetails> findByProductName(@RequestParam String productName){
        return this.productService.findByProductName(productName);
    }

    @GetMapping("/find-by-pn-up")
    public DataResult<Product> findByProductNameAndUnitPrice( @RequestParam String productName, @RequestParam int unitPrice){
        return this.productService.findByProductNameAndUnitPrice(productName, unitPrice);
    }


}
