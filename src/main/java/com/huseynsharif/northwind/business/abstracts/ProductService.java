package com.huseynsharif.northwind.business.abstracts;

import com.huseynsharif.northwind.core.utilities.results.DataResult;
import com.huseynsharif.northwind.core.utilities.results.Result;
import com.huseynsharif.northwind.entities.Product;
import com.huseynsharif.northwind.entities.dtos.ProductDto;
import com.huseynsharif.northwind.entities.dtos.ProductWithCategoryDetails;

import java.util.List;

public interface ProductService {
    // beu.ict.lab
    DataResult<List<Product>> getAll();
    Result add(ProductDto productDto);
    DataResult<ProductWithCategoryDetails> findByProductName(String productName);
    DataResult<Product> findByProductNameAndUnitPrice(String productName, int unitPrice);

}
