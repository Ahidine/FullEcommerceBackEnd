package com.ecommerce.demo;

import com.ecommerce.demo.dao.CategoryRepository;
import com.ecommerce.demo.dao.ProductRespository;
import com.ecommerce.demo.entites.Category;
import com.ecommerce.demo.entites.Product;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.Random;

@SpringBootApplication
public class DemoApplication  implements CommandLineRunner {
    @Autowired
    private ProductRespository produitRepositroy;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private RepositoryRestConfiguration repositoryRestConfiguration;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        repositoryRestConfiguration.exposeIdsFor(Product.class,Category.class);
 /*       categoryRepository.save(new Category(null,"Imprimantes",null,null));
        categoryRepository.save(new Category(null,"Ordinateurs",null,null));
        categoryRepository.save(new Category(null,"SmartPhones",null,null));
        Random r= new Random();
        categoryRepository.findAll().forEach(c -> {
            for (int i = 0; i <15 ; i++) {
                Product p =new Product();
                p.setNom(RandomString.make(10));
                p.setCurrentPrice(100.00+(r.nextDouble()*1000));
                p.setAvailabe(r.nextBoolean());
                p.setPhotoName(null);
                p.setQuantite(10+r.nextInt(1000));
                p.setSelected(r.nextBoolean());
                p.setAvailabe(r.nextBoolean());
                p.setCategorie(c);
                produitRepositroy.save(p);
            }
        });*/
        Random r= new Random();
       produitRepositroy.findAll().forEach(product -> {
           product.setPromotion(r.nextBoolean());
            produitRepositroy.save(product);
        });

    }
}
