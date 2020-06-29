package com.example.sellions.dao.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Parameter {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long parameter_id;

    private String product_name;

    private String name;

    private String value;




    public Parameter parameter_id(Long parameter_id) {
        this.parameter_id = parameter_id;
        return this;
    }

    public Parameter name(String name) {
        this.name = name;
        return this;
    }

    public Parameter value(String value) {
        this.value = value;
        return this;
    }


    public Parameter product_name(String product_name) {
        this.product_name = product_name;
        return this;
    }
}
