package com.spring.produits;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring.produits.entities.Categorie;
import com.spring.produits.entities.Produit;
import com.spring.produits.repos.CategorieRepository;
import com.spring.produits.repos.ProduitRepository;

@SpringBootTest
class ProduitsApplicationTests {

	@Autowired
	private ProduitRepository produitRepository;
	@Autowired
	private CategorieRepository categorieRepository;

	@Test
	public void testCreateProduit() {
		Produit p = new Produit("Imprimante Huawei", 3100.0, new Date(), categorieRepository.findById(2l).get());
		produitRepository.save(p);
	}
	
	@Test
	public void testCreateCategorie() {
		Categorie c = new Categorie("Play Station", "Produits de type PS");
		Produit p = new Produit("PS 4", 3000.0, new Date(), c);
		categorieRepository.save(c);
		produitRepository.save(p);
	}

	@Test
	public void testFindProduit() {
		Produit p = produitRepository.findById(7L).get();
		System.out.println(p);
	}

	@Test
	public void testUpdateProduit() {
		Produit p = produitRepository.findById(6L).get();
		p.setPrix(1000.0);
		produitRepository.save(p);
	}

	@Test
	public void testDeleteProduit() {
		produitRepository.deleteById(1L);
		;
	}

	@Test
	public void testListerTousProduits() {
		List<Produit> prods = produitRepository.findAll();
		for (Produit p : prods) {
			System.out.println(p);
		}
	}

	@Test
	public void testFindByNomProduit() {
		List<Produit> prods = produitRepository.findByNom("iphone X");
		for (Produit p : prods) {
			System.out.println(p);
		}
	}

	@Test
	public void testFindByDateCreationBeforeOrderByPrixDesc() {
		List<Produit> prods = produitRepository
				.findByDateCreationBeforeOrderByPrixDesc(new Date());
		for (Produit p : prods) {
			System.out.println(p);
		}
	}

	@Test
	public void testFindByNomPrix() {
		List<Produit> prods = produitRepository.findByNomPrix("PC", 1500.7);
		for (Produit p : prods) {
			System.out.println(p);
		}
	}

	@Test
	public void testFindByCategorieId() {
		List<Produit> prods = produitRepository.findByCategorieId(1l);
		for (Produit p : prods) {
			System.out.println(p);
		}
	}

	@Test
	public void testFindByCategorieNom() {
		List<Produit> prods = produitRepository.findByOrderByNomAsc();
		for (Produit p : prods) {
			System.out.println(p);
		}
	}

	@Test
	public void testFindByOrderByNomAsc() {
		List<Produit> prods = produitRepository.findByCategorieNom("Imprimante");
		for (Produit p : prods) {
			System.out.println(p);
		}
	}

	@Test
	public void testTrierProduitsNomsPrix() {
		List<Produit> prods = produitRepository.trierProduitsNomsPrix();
		for (Produit p : prods) {
			System.out.println(p);
		}
	}
}
