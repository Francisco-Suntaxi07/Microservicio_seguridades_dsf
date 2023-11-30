package com.sfsl.products.dao;

import com.sfsl.products.model.ProductModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductDao extends CrudRepository<ProductModel,String> {


}
