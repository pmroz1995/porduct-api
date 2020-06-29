package com.example.sellions.dbSetup;

import com.example.sellions.dao.CategoryRepository;
import com.example.sellions.dao.CommentRepository;
import com.example.sellions.dao.ParameterRepository;
import com.example.sellions.dao.ProductRepository;
import com.example.sellions.dao.entity.Category;
import com.example.sellions.dao.entity.Comment;
import com.example.sellions.dao.entity.Parameter;
import com.example.sellions.dao.entity.Product;
import com.example.sellions.dao.enums.Status;
import com.example.sellions.service.ParameterServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ApplicationContextEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Component
public class SetUpDb {

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;
    private CommentRepository commentRepository;
    private ParameterRepository parameterRepository;


    @Autowired
    public SetUpDb(ProductRepository productRepository,
                   CategoryRepository categoryRepository,
                   CommentRepository commentRepository,
                   ParameterRepository parameterRepository)
    {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.commentRepository = commentRepository;
        this.parameterRepository = parameterRepository;
    }


    public Product saveProduct(Product product){
        return productRepository.save(product);
    }

    public Category saveCategory(Category category){
        return categoryRepository.save(category);
    }

    public Comment saveComment(Comment comment){
        return commentRepository.save(comment);
    }

    public Parameter saveParameter(Parameter parameter){
        return parameterRepository.save(parameter);
    }


    @EventListener(ApplicationContextEvent.class)
    public void setUpDB(){
        Category categoryPralka = new Category().category_id(1l).name("Pralka");
        Category categoryAparat = new Category().category_id(2l).name("Aparat");
        Category categoryTelefon = new Category().category_id(3l).name("telefon");

        Product product1 = new Product().id(1l)
                .name("Pralka")
                .model("frania")
                .prize(1233L)
                .brand("philips")
                .weight(80L)
                .productionYear(LocalDate.now().minusYears(10))
                .colour("czarny")
                .status(Status.SPRAWNY)
                .category(categoryPralka);

        Product product2 =new Product().id(2l)
                .name("Pralka")
                .model("model5")
                .prize(1233L)
                .brand("Amica")
                .weight(80L)
                .productionYear(LocalDate.now().minusYears(10))
                .colour("bialy")
                .status(Status.SPRAWNY)
                .category(categoryPralka);

        Product product3 = new Product()
                .id(3l)
                .name("Aparat")
                .prize(900L)
                .brand("icon")
                .colour("zielnoy")
                .status(Status.SPRAWNY)
                .category(categoryAparat);

        Product product4 = new Product()
                .id(4l)
                .name("Aparat")
                .prize(800L)
                .brand("panasonic")
                .colour("czarny")
                .status(Status.SPRAWNY)
                .category(categoryAparat);



        Parameter parameter1 = new Parameter().parameter_id(1L).name("reslution").value("7 cali").product_name("telefon");
        Parameter parameter2 = new Parameter().parameter_id(2L).name("screenType").value("Gorilla Glass").product_name("telefon");

        Set<Parameter> parameters = new HashSet<>();
        parameters.add(parameter1);
        parameters.add(parameter2);

        Product product5 = new Product()
                .id(5l)
                .name("telefon")
                .prize(750L)
                .brand("Xiaomi")
                .colour("czarny")
                .status(Status.NIESPRAWNY)
                .category(categoryTelefon)
                .parameters(parameters);



        saveParameter(parameter1);
        saveParameter(parameter2);

        saveCategory(categoryPralka);
        saveCategory(categoryAparat);
        saveCategory(categoryTelefon);

        saveProduct(product1);
        saveProduct(product2);
        saveProduct(product3);

        saveProduct(product4);
        saveProduct(product5);




    }


}
