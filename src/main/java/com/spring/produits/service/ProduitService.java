package com.spring.produits.service;

import java.util.Date;
import java.util.List;

import com.spring.produits.dto.ProduitDTO;
import com.spring.produits.entities.Categorie;
import com.spring.produits.entities.Produit;

public interface ProduitService {
	
	ProduitDTO convertEntityToDto (Produit produit);
	
	Produit convertDtoToEntity(ProduitDTO produitDto);
	
	ProduitDTO saveProduit(ProduitDTO p);

	ProduitDTO updateProduit(ProduitDTO p);

	void deleteProduit(ProduitDTO p);

	void deleteProduitById(Long id);

	ProduitDTO getProduit(Long id);

	List<ProduitDTO> getAllProduits();

	List<ProduitDTO> findByNom(String nom);

	List<ProduitDTO> findByDateCreationBeforeOrderByPrixDesc(Date dateCreation);

	List<ProduitDTO> findByNomPrix(String nom, Double prix);

	List<ProduitDTO> findByCategorie(Categorie categorie);

	List<ProduitDTO> findByCategorieId(Long id);

	List<ProduitDTO> findByCategorieNom(String nom);

	List<ProduitDTO> findByOrderByNomAsc();

	List<ProduitDTO> trierProduitsNomsPrix();

}
