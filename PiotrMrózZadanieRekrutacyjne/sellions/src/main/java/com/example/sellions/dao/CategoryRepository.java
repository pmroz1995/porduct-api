package com.example.sellions.dao;

import com.example.sellions.dao.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {

    @Override
    Optional<Category> findById(Long aLong);
}
