package com.example.demo.Repository;

import java.util.List;

public interface ICrudRepository<T> {

    void addProduct(T p);
    List<T> getAllProducts();
    T findProductById(long id);
    void updateProduct(T p);
    void deleteProduct(long id);

}
