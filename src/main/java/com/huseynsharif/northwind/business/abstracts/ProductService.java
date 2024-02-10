package com.huseynsharif.northwind.business.abstracts;

import com.huseynsharif.northwind.core.utilities.results.DataResult;
import com.huseynsharif.northwind.core.utilities.results.Result;
import com.huseynsharif.northwind.entities.Product;

import java.util.List;

public interface ProductService {
    // beu.ict.lab
    DataResult<List<Product>> getAll();
    Result add(Product product);
    DataResult<Product> findByProductName(String productName);
    DataResult<Product> findByProductNameAndUnitPrice(String productName, int unitPrice);

}
