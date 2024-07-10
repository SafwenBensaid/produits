package com.spring.produits.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.spring.produits.entities.Categorie;

public interface CategorieRepository extends JpaRepository<Categorie, Long> {
}
