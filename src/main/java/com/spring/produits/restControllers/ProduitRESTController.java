package com.spring.produits.restControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.produits.dto.ProduitDTO;
import com.spring.produits.service.ProduitService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ProduitRESTController {
	@Autowired
	ProduitService produitService;

	@GetMapping
	public List<ProduitDTO> getAllProduits() {
		return produitService.getAllProduits();
	}

	@GetMapping("/{id}")
	public ProduitDTO getProduitById(@PathVariable("id") Long id) {
		return produitService.getProduit(id);
	}

	@PostMapping
	public ProduitDTO createProduit(@RequestBody ProduitDTO produit) {
		return produitService.saveProduit(produit);
	}

	@PutMapping
	public ProduitDTO updateProduit(@RequestBody ProduitDTO produit) {
		return produitService.updateProduit(produit);
	}

	@DeleteMapping("/{id}")
	public void deleteProduit(@PathVariable("id") Long id) {
		produitService.deleteProduitById(id);
	}

	@GetMapping("/categorie/{idCat}")
	public List<ProduitDTO> getProduitsByCatId(@PathVariable("idCat") Long idCat) {
		return produitService.findByCategorieId(idCat);
	}

	@GetMapping("/nomContains/{nom}/prixGreaterThan/{prix}")
	public List<ProduitDTO> findByNomPrix(@PathVariable("nom") String nom, @PathVariable("prix") Double prix) {
		return produitService.findByNomPrix(nom, prix);
	}

}
