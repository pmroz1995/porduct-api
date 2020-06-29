package com.example.sellions.service;

import com.example.sellions.dao.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {


    Optional<Product> findById(Long id);

    Iterable<Product> findAll();

    void deleteById(Long id);

    void save(Product product);

    void update(Product product);

    List<Product> findProductsByCategoryId(Long id);

    List<Product> findProductsByCategoryName(String id);

    void changeStatus(Long id);




}
