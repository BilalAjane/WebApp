package com.example.demo.Controller;

import com.example.demo.Model.Product;
import com.example.demo.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class restController {

    @Autowired
    ProductService productService;

    @GetMapping("/products")
    public List<Product> allProducts() {
        return productService.getAll();
        //return new ResponseEntity<Product>(productService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable("id") int id) {
        return productService.findProductById(id);
    }

    @PostMapping("/products")
    public ResponseEntity<Product> createCustomer(@RequestBody Product product) {
        productService.create(product);
        HttpHeaders headers = new HttpHeaders();
        headers.add("location", "/products/" + product.getIdproduct());
        //return new ResponseEntity<Product>(product, headers, HttpStatus.CREATED);
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<Product> productUpdate(@PathVariable("id") long id, @RequestBody Product product ) {
        product.setIdproduct(id);
        productService.updateProduct(product);
        return ResponseEntity.ok().build();

        //productService.findProductById(id);
        //if product with id exist
        //productService.updateProduct(product);
        //return new ResponseEntity<Product>(HttpStatus.OK); //200 OK
        //else //Product with id does not exist
        //return new ResponseEntity<>(HttpStatus.NOT_FOUND); //404 NOT_FOUND
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<Void> deleteBookById(@PathVariable("id") long id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok().build();
    }

}
