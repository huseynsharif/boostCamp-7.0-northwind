package com.huseynsharif.northwind.api.controllers;

import com.huseynsharif.northwind.business.abstracts.ProductService;
import com.huseynsharif.northwind.core.utilities.results.DataResult;
import com.huseynsharif.northwind.core.utilities.results.ErrorDataResult;
import com.huseynsharif.northwind.core.utilities.results.Result;
import com.huseynsharif.northwind.entities.Product;
import com.huseynsharif.northwind.entities.dtos.ProductDto;
import com.huseynsharif.northwind.entities.dtos.ProductWithCategoryDetails;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public Result add(@RequestBody @Valid ProductDto productDto){
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

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions){

        Map<String, String> validationErrors = new HashMap<String, String>();

        for(FieldError fieldError : exceptions.getBindingResult().getFieldErrors()){

            validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());

        }

        ErrorDataResult<Object> errors = new ErrorDataResult<Object>("Validasyon hatalari.",validationErrors);

        return errors;
    }
}
