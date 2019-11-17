package com.ecommerce.demo.entites;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Collection;
@Entity
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String description;
    private double currentPrice;
    private boolean isAvailabe;
    private boolean isSelected;
    private boolean isPromotion;
    private String photoName;
    private int quantite;
    @ManyToOne
    private Category categorie;

}
