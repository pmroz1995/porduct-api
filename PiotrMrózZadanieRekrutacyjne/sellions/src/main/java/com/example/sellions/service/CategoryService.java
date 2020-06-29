package com.example.sellions.service;

import com.example.sellions.dao.entity.Category;

import java.util.Optional;

public interface CategoryService {

    Optional<Category> findById(Long id);

    Iterable<Category> findAll();

    void deleteById(Long id);

    Category save(Category category);
}
