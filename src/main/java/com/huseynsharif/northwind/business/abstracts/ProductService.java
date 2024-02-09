package com.huseynsharif.northwind.business.abstracts;

import com.huseynsharif.northwind.core.utilities.results.DataResult;
import com.huseynsharif.northwind.entities.Product;

import java.util.List;

public interface ProductService {
    // beu.ict.lab
    DataResult<List<Product>> getAll();
}
