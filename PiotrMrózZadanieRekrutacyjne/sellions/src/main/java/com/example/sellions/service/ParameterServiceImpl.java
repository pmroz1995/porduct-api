package com.example.sellions.service;

import com.example.sellions.dao.ParameterRepository;
import com.example.sellions.dao.ProductRepository;
import com.example.sellions.dao.entity.Parameter;
import com.example.sellions.dao.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class ParameterServiceImpl implements ParameterService {

    private ParameterRepository parameterRepository;
    private ProductRepository productRepository;
    private ProductService productService;

    @Autowired
    public ParameterServiceImpl(ParameterRepository parameterRepository,
                                ProductRepository productRepository,
                                ProductService productService
                                ){
        this.parameterRepository = parameterRepository;
        this.productRepository = productRepository;
        this.productService = productService;

    }


    @Override
    public void save(long id,Parameter parameter) {
        Product product = productRepository.findAll()
                .stream()
                .filter(e -> e.getProduct_id().equals(id))
                .findAny().orElseThrow(() -> new RuntimeException());


        if(!product.equals(null)){

            product.getParameters().add(parameter);
            productService.update(product);
        }

        parameterRepository.save(parameter);




    }



}
