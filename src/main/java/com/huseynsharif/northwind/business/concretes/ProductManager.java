package com.huseynsharif.northwind.business.concretes;

import com.huseynsharif.northwind.business.abstracts.ProductService;
import com.huseynsharif.northwind.core.utilities.results.*;
import com.huseynsharif.northwind.dataAccess.CategoryDao;
import com.huseynsharif.northwind.dataAccess.ProductDao;
import com.huseynsharif.northwind.entities.Category;
import com.huseynsharif.northwind.entities.Product;
import com.huseynsharif.northwind.entities.dtos.ProductDto;
import com.huseynsharif.northwind.entities.dtos.ProductWithCategoryDetails;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;

@Service
@AllArgsConstructor
public class ProductManager implements ProductService {

    private ProductDao productDao;
    private CategoryDao categoryDao;

    @Override
    public DataResult<List<Product>> getAll() {

        return new SuccesDataResult<>("Ugurla listelendi.", this.productDao.findAll());
    }

    @Override
    public Result add(ProductDto productDto) {

        Category category = this.categoryDao.findById(productDto.getCategoryId()).orElse(null);


        Product product = new Product(
                productDto.getProductName(),
                category,
                productDto.getQuantityPerUnit(),
                productDto.getUnitPrice()
        );

        this.productDao.save(product);

        return new SuccessResult("Ugurla save olundu.");
    }

    @Override
    public DataResult<ProductWithCategoryDetails> findByProductName(String productName) {
        Product product = this.productDao.findByProductName(productName);

        if (product==null){
            return new ErrorDataResult<>("Bele adda product yoxdur!");
        }
        else{
            ProductWithCategoryDetails response = new ProductWithCategoryDetails(
                    product.getProductName(),
                    product.getCategory().getCategoryName(),
                    product.getQuantityPerUnit(),
                    product.getUnitPrice()
            );
            return new SuccesDataResult<>("Ugurla tapildi.", response);
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

    @Override
    public DataResult<List<Product>> getAllByPage(int pageNo, int pageSize) {

        if (pageNo<1){
            return new ErrorDataResult<>("Page No 1-den kicik ola bilmez.");
        }

        if (pageSize<1){
            return new ErrorDataResult<>("Page size 1-den kicik ola bilmez.");
        }

        PageRequest pageable = PageRequest.of(pageNo-1, pageSize);
        List<Product> data = this.productDao.findAll(pageable).getContent();
        if (data.isEmpty()){
            return new ErrorDataResult<>("Out of bounds");
        }
        return new SuccesDataResult<>("Page ile siralandi.", data);

    }
}
