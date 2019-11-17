package com.ecommerce.demo.dao;

import com.ecommerce.demo.entites.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
@RepositoryRestResource
public interface CategoryRepository  extends JpaRepository<Category,Long> {
}
