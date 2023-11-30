package com.sfsl.products.controller;

import com.sfsl.products.model.ProductModel;
import com.sfsl.products.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class WebController {
    @Autowired
    IProductService productService;

    @GetMapping("/home")
    public String showProductsList( Model model) {
        model.addAttribute("productsList",productService.findAllProducts());
        return "home";
    }

    @GetMapping("/new")
    public String addProduct( Model model) {
        model.addAttribute("product",new ProductModel());
        return "productForm";
    }

    @PostMapping("/save")
    public String saveProduct(@Validated ProductModel productModel, Model model){
        productService.saveProduct(productModel);
        return "redirect:/home";
    }

    @GetMapping("/edit/{id}")
    public String editProduct(@PathVariable String id, Model model){
        Optional<ProductModel> productModel = productService.findProductById(id);
        model.addAttribute("product", productModel);
        return "productForm";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable String id, Model model){
        productService.deleteProductByID(id);
        return "redirect:/home";
    }

}
