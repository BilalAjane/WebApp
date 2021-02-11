package com.example.demo.Service;

import com.example.demo.Model.Product;
import com.example.demo.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> getAll() {
        List<Product> products = new ArrayList<>();
        for (Product product : productRepository.getAllProducts()) {
            products.add(product);
        }
        return products;
    }

    public Product findProductById(long id) {
        return productRepository.findProductById(id);
    }

    public void create(Product product) {
        productRepository.addProduct(product);
    }

    public void updateProduct(Product product) {
        productRepository.updateProduct(product);
    }

    public void deleteProduct(long id) {
        productRepository.deleteProduct(id);
    }
}