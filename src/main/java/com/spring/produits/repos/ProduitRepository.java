package com.spring.produits.repos;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.spring.produits.entities.Categorie;
import com.spring.produits.entities.Produit;

@RepositoryRestResource(path = "rest")
public interface ProduitRepository extends JpaRepository<Produit, Long> {
	List<Produit> findByNom(String nom);

	List<Produit> findByDateCreationBeforeOrderByPrixDesc(Date dateCreation);

	@Query("select p from Produit p where p.nom like %:nom% and p.prix > :prix")
	List<Produit> findByNomPrix(@Param("nom") String nom, @Param("prix") Double prix);

	List<Produit> findByCategorie(Categorie categorie);
	
	List<Produit> findByCategorieId(Long id);

	List<Produit> findByCategorieNom(String nom);

	List<Produit> findByOrderByNomAsc();
	
	@Query("select p from Produit p order by p.nom ASC, p.prix DESC")
	List<Produit> trierProduitsNomsPrix ();
}
