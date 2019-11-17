package com.ecommerce.demo.entites;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Category implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private  String descirpiton;
    @OneToMany(mappedBy = "categorie")
    private Collection<Product> produits;


}
