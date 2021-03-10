package com.example.demo.Repository;

import com.example.demo.Model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements ICrudRepository<Product>{

    @Autowired
    JdbcTemplate template;

    private List<Product> products = new ArrayList<>();

    public ProductRepository(){
        this.products.add(new Product(1,"Gamer Stol",1200.0));
        this.products.add(new Product(2,"Gamer Bord",1000.0));
        this.products.add(new Product(3,"Gamer Mus",900.0));
        this.products.add(new Product(4,"Gamer Skærm",1399.0));
    }

    @Override
    public List<Product> getAllProducts() {
        String sql = "SELECT * FROM product";
        RowMapper<Product> rowMapper = new BeanPropertyRowMapper<>(Product.class);

        return template.query(sql,rowMapper);
    }

    @Override
    public void addProduct(Product products){
        String sql = "INSERT INTO product (idproduct, productName, productPrice) VALUES (?, ?, ?)";
        template.update(sql, products.getIdproduct(), products.getProductName(), products.getProductPrice());
    }

    @Override
    public void deleteProduct(long idproduct){
        String sql = "DELETE FROM product WHERE idproduct=?";
        template.update(sql, idproduct);
    }

    @Override
    public Product findProductById(long idproduct){
        String sql = "SELECT * FROM product WHERE idproduct=?";
        RowMapper<Product> rowMapper = new BeanPropertyRowMapper<>(Product.class);
        return template.queryForObject(sql, rowMapper, idproduct);
    }

    @Override
    public void updateProduct(Product product){
        String sql = "UPDATE product SET productName=?, productPrice=? WHERE idproduct=?";
        template.update(sql, product.getProductName(), product.getProductPrice(), product.getIdproduct());
    }

}
