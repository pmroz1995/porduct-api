package com.example.sellions.dao.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Comment {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long comment_id;

    private String product_name;

    private String name;

    private String message;

    @ManyToOne
    @JoinColumn()
    private Product product;
}
