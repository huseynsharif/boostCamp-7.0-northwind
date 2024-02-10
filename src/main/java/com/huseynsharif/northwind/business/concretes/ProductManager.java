package com.huseynsharif.northwind.business.concretes;

import com.huseynsharif.northwind.business.abstracts.ProductService;
import com.huseynsharif.northwind.core.utilities.results.*;
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
    public DataResult<List<Product>> getAll() {

        return new SuccesDataResult<>("Ugurla listelendi.", this.productDao.findAll());
    }

    @Override
    public Result add(Product product) {

        this.productDao.save(product);

        return new SuccessResult("Ugurla save olundu.");
    }

    @Override
    public DataResult<Product> findByProductName(String productName) {
        Product product = this.productDao.findByProductName(productName);

        if (product==null){
            return new ErrorDataResult<>("Bele adda product yoxdur!");
        }
        else{
            return new SuccesDataResult<>("Ugurla tapildi.", product);
        }
    }

    @Override
    public DataResult<Product> findByProductNameAndUnitPrice(String productName, int unitPrice) {
        Product product = this.productDao.findByProductNameAndUnitPrice(productName, unitPrice);

        if (product==null){
            return new ErrorDataResult<>("Bele xususiyyetlerde product yoxdur!");
        }
        else{
            return new SuccesDataResult<>("Ugurla tapildi.", product);
        }
    }
}
