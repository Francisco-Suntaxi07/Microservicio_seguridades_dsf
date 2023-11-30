package com.sfsl.products.service;

import com.sfsl.products.model.ProductModel;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    public List<ProductModel> findAllProducts();
    public ProductModel saveProduct(ProductModel product);
    public Optional<ProductModel> findProductById(String id);
    public Boolean deleteProductByID(String id);
}
