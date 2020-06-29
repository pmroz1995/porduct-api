package com.example.sellions.service;

import com.example.sellions.dao.CategoryRepository;
import com.example.sellions.dao.ProductRepository;
import com.example.sellions.dao.entity.Category;
import com.example.sellions.dao.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.example.sellions.dao.enums.Status.NIESPRAWNY;
import static com.example.sellions.dao.enums.Status.SPRAWNY;


@Service
public class ProductServiceImpl implements ProductService{

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductServiceImpl(ProductRepository productRepository,
                               CategoryRepository categoryRepository
    ){
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Product> findProductsByCategoryId(Long id){
        return productRepository.findAll()
                .stream()
                .filter(e -> e.getCategory().getCategory_id().equals(id)
                ).collect(Collectors.toList());
    }

    @Override
    public List<Product> findProductsByCategoryName(String id) {
        Category category = categoryRepository
                .findAll()
                .stream()
                .filter(e -> e.getCategory_name().toUpperCase().equals(id.toUpperCase()))
                .findFirst()
                .get();

        return productRepository
                .findAll()
                .stream()
                .filter(e -> e.getCategory().equals(category))
                .collect(Collectors.toList());
    }

    @Override
    public void changeStatus(Long id) {
        Product product = productRepository
                .findById(id)
                .filter(e -> e.getStatus().equals(SPRAWNY))
                .orElseThrow(RuntimeException::new);

        if(product.getStatus().equals(SPRAWNY)){
            product.setStatus(NIESPRAWNY);
            productRepository.save(product);
        }else{
            throw new RuntimeException();
        }


    }

    @Override
    public Optional<Product> findById(Long id){
        return productRepository.findById(id);
    }

    @Override
    public Iterable<Product> findAll(){
        return productRepository.findAll();
    }

    @Override
    public void deleteById(Long id) throws RuntimeException{
        productRepository.findAll()
                .stream()
                .filter(e -> e.getProduct_id().equals(id))
                .findAny()
                .orElseThrow(() -> new RuntimeException(""));

        productRepository.deleteById(id);
    }

    @Override
    public void save(Product product) throws RuntimeException{

        int hashCode0 = productRepository.findAll().hashCode();
        if(product.getProduct_id() == null){
            productRepository.save(product);
        }

        int hashCode1 = productRepository.findAll().hashCode();

        Product product1 =productRepository.findAll()
                .stream()
                .filter(e ->e.getProduct_id().equals(product.getProduct_id()))
                .findAny()
                .orElse(productRepository.save(product));

        int hashCode2 = productRepository.findAll().hashCode();

        if((hashCode1 == hashCode2)&&(hashCode0 == hashCode2)){
            throw new RuntimeException();
        }

    }

    @Override
    public void update(Product product){
        productRepository.findAll()
                .stream()
                .filter(e -> e.getProduct_id().equals(product.getProduct_id()))
                .findAny()
                .orElseThrow(() -> new RuntimeException(""));


        productRepository.save(product);

    }


}
