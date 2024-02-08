package com.huseynsharif.northwind.business.concretes;

import com.huseynsharif.northwind.business.abstracts.ProductService;
import com.huseynsharif.northwind.dataAccess.ProductDao;
import com.huseynsharif.northwind.entities.Product;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductManager implements ProductService {

    private ProductDao productDao;

    @Override
    public List<Product> getAll() {
        return this.productDao.findAll();
    }
}
