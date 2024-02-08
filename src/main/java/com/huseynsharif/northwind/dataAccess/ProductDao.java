package com.huseynsharif.northwind.dataAccess;

import com.huseynsharif.northwind.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDao extends JpaRepository<Product, Integer> {
}
