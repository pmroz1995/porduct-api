package com.example.sellions.controller;

import com.example.sellions.Exceptions.SupportingRuntimeError;
import com.example.sellions.dao.ProductRepository;
import com.example.sellions.dao.entity.Category;
import com.example.sellions.dao.entity.Product;
import com.example.sellions.service.CategoryService;
import com.example.sellions.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static com.example.sellions.Exceptions.ExceptionMessagesLibrary.*;

@RestController
@RequestMapping("/sellionsApi")
public class ApiController {

    private ProductRepository productRepository;
    private ProductService productService;
    private CategoryService categoryService;

    @Autowired
    public ApiController(ProductService productService,
                         ProductRepository productRepository,
                         CategoryService categoryService){
        this.productService = productService;
        this.productRepository = productRepository;
        this.categoryService = categoryService;
    }

    @GetMapping("/getCategory")
    public Optional<Category> findCategoryById(@RequestParam long index){
        return categoryService.findById(index);
    }

    @GetMapping("/getProductsByCategoryId")
    public List<Product> findProductsByCategoryId(@RequestParam long index){
        return productService.findProductsByCategoryId(index);
    }

    @GetMapping("/getProductsByCategoryName/{index}")
    public List<Product> findProductsByCategoryName(@PathVariable String index){
        return productService.findProductsByCategoryName(index);
    }

    @GetMapping("/getAll")
    public Iterable<Product> getAll() {
        return productRepository.findAll();
    }

    @PostMapping("/postProduct")
    public void addProduct(@RequestBody Product product){
         try{
             productService.save(product);
         }
         catch (RuntimeException ex){
             throw new SupportingRuntimeError(YOU_CANNOT_ADD_PRODUCT);
         }
    }

    @PostMapping("/changeStatus/{id}")
    public void disableProduct(@PathVariable long id){
        try {
            productService.changeStatus(id);
        }
        catch(RuntimeException ex){
            new SupportingRuntimeError(YOU_CANNOT_CHANGE_STATUS);
        }
    }

    @GetMapping("/getProduct/{id}")
    public Product findById(@PathVariable long id){
        return productService.findById(id)
                .orElseThrow(() -> new SupportingRuntimeError(THERE_IS_PRODUCT_WITH_ID));
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProduct(@PathVariable long id){
        try {
            productService.deleteById(id);
        }catch(RuntimeException ex){
            throw new SupportingRuntimeError(YOU_CANNOT_DELETE_PRODUCT);
        }
    }

    @PatchMapping
    public void updateProduct(@RequestBody Product product){
        try {
            productService.update(product);
        }catch(RuntimeException ex){
            throw new SupportingRuntimeError(THERE_IS_PRODUCT_WITH_ID);
        }
    }


}
