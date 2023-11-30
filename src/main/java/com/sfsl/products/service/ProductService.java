package com.sfsl.products.service;

import com.sfsl.products.dao.IProductDao;
import com.sfsl.products.model.ProductModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;


@Service
public class ProductService implements IProductService{
    @Autowired
    IProductDao productDao;

    @Override
    public List<ProductModel> findAllProducts() {
        return (ArrayList<ProductModel>) productDao.findAll();
    }

    @Override
    public ProductModel saveProduct(ProductModel product) {

        String name = encryptData(product.getName());
        String brand = encryptData(product.getBrand());

        product.setName(name);
        product.setBrand(brand);

        return productDao.save(product);
    }


    @Override
    public Optional<ProductModel> findProductById(String id) {
        Optional<ProductModel> optionalProduct = productDao.findById(id);

        if (optionalProduct.isPresent()) {
            ProductModel product = optionalProduct.get();
            product.setName(decryptData(product.getName()));
            product.setBrand(decryptData(product.getBrand()));
            return Optional.of(product);
        } else {
            return Optional.empty();
        }
    }

    private String encryptData(String data) {

        return Base64.getEncoder().encodeToString(data.getBytes());
    }

    private String decryptData(String encryptedData) {

        return new String(Base64.getDecoder().decode(encryptedData));
    }

    @Override
    public Boolean deleteProductByID(String id) {
        try{
            productDao.deleteById(id);
            return true;
        }catch(Exception e){
            return false;
        }
    }

}
