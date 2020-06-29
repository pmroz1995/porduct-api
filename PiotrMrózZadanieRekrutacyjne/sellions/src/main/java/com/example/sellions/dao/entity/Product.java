package com.example.sellions.dao.entity;

import com.example.sellions.dao.enums.Status;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Setter
@NoArgsConstructor

public class Product {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long product_id;

    private String name;

    private String brand;

    private String model;

    private String colour;

    private Long prize;

    private Long weight;

    private LocalDate productionYear;

    private Status status;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Parameter> parameters;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Comment> comments;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    @Fetch(FetchMode.JOIN)
    protected Category category;


    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    public String getName(){
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getColour() {
        return colour;
    }

    public Long getPrize() {
        return prize;
    }

    public Long getWeight() {
        return weight;
    }

    public LocalDate getProductionYear() {
        return productionYear;
    }

    public Status getStatus() {
        return status;
    }

    public Set<Parameter> getParameters() {
        return parameters;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public Category getCategory() {
        return category;
    }


    public Product id(Long id) {
        this.product_id = id;
        return this;
    }

    public Product name(String name) {
        this.name = name;
        return this;
    }

    public Product brand(String brand) {
        this.brand = brand;
        return this;
    }

    public Product model(String model) {
        this.model = model;
        return this;
    }

    public Product colour(String colour) {
        this.colour = colour;
        return this;
    }

    public Product weight(Long weight) {
        this.weight = weight;
        return this;
    }

    public Product prize(Long prize) {
        this.prize = prize;
        return this;
    }

    public Product productionYear(LocalDate productionYear) {
        this.productionYear = productionYear;
        return this;
    }

    public Product status(Status status) {
        this.status = status;
        return this;
    }


    public Product product_id(Long product_id) {
        this.product_id = product_id;
        return this;
    }

    public Product parameters(Set<Parameter> parameters) {
        this.parameters = parameters;
        return this;
    }

    public Product comments(Set<Comment> comments) {
        this.comments = comments;
        return this;
    }

    public Product category(Category category) {
        this.category = category;
        return this;
    }
}
