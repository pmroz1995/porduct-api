package com.example.sellions.service;

import com.example.sellions.dao.CommentRepository;
import com.example.sellions.dao.ProductRepository;
import com.example.sellions.dao.entity.Comment;
import com.example.sellions.dao.entity.Product;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    private CommentRepository commentRepository;
    private ProductRepository productRepository;
    private ProductService productService;

    public CommentServiceImpl(CommentRepository commentRepository,
                              ProductRepository productRepository,
                              ProductService productService)
    {
        this.commentRepository = commentRepository;
        this.productRepository = productRepository;
        this.productService = productService;
    }


    @Override
    public void save(long id,Comment comment) {
        Product product = productRepository.findAll()
                .stream()
                .filter(e -> e.getProduct_id().equals(id))
                .findAny().orElseThrow(() -> new RuntimeException());

        if(!product.equals(null)){

            product.getComments().add(comment);
            productService.update(product);
        }

        commentRepository.save(comment);

    }
}
