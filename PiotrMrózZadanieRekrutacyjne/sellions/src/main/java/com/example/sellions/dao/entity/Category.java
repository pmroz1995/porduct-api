package com.example.sellions.dao.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Category {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long category_id;

    private String category_name;

    @OneToMany
    private Set<Product> products;


    public Category id(Long id) {
        this.category_id = id;
        return this;
    }

    public Category name(String name) {
        this.category_name = name;
        return this;
    }

    public Category products(Set<Product> products) {
        this.products = products;
        return this;
    }

    public Category category_id(Long category_id) {
        this.category_id = category_id;
        return this;
    }
}
