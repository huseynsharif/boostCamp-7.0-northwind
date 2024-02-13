package com.huseynsharif.northwind.dataAccess;

import com.huseynsharif.northwind.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryDao extends JpaRepository<Category,Integer> {
}
