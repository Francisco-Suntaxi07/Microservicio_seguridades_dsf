package com.sfsl.products.controller;

import com.sfsl.products.model.ProductModel;
import com.sfsl.products.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ProductsRestController {

    @Autowired
    IProductService productService;

    @GetMapping("/greeting")
    public String greeting(){
        return "Bienvenido a mi api rest";
    }

    @GetMapping("/products/all")
    public ResponseEntity<List<ProductModel>> findAllProducts(){
        return new ResponseEntity<>(productService.findAllProducts(),HttpStatus.OK);
    }

    @PostMapping("/products/save")
    public ResponseEntity<ProductModel> saveProduct(@Validated @RequestBody ProductModel product){
        return new ResponseEntity<>(productService.saveProduct(product),HttpStatus.OK);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Optional<ProductModel>> findProductById(@PathVariable("id") String id){
        return new  ResponseEntity<>(productService.findProductById(id),HttpStatus.OK);
    }

    @DeleteMapping("/products/delete/{id}")
    public ResponseEntity<String> deleteProductByID(@PathVariable("id") String id){
        boolean aux = productService.deleteProductByID(id);
        if(aux){
            return new ResponseEntity<>("Se elimino el producto con id: "+id,HttpStatus.OK);
        }else{
            return new ResponseEntity<>("No se pudo eliminar el producto con id: "+id,HttpStatus.OK);
        }
    }
}
