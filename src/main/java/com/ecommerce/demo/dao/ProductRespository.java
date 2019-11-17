package com.ecommerce.demo.dao;


import com.ecommerce.demo.entites.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
@CrossOrigin("*")
@RepositoryRestResource
public interface ProductRespository extends JpaRepository<Product,Long> {
    @RestResource(path = "/SelectedProducts")
    public List<Product> findByIsSelectedIsTrue();
    @RestResource(path = "/AvailablesProducts")
    public List<Product> findByIsAvailabeIsTrue();
    @RestResource(path = "/PromotionsProducts")
    public List<Product> findByIsPromotionTrue();
    @RestResource(path = "/ProductsByName")
    public List<Product> findByNomContains(@Param("mc") String mc);
}
