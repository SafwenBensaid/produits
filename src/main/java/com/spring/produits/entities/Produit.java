package com.spring.produits.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Produit {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private Double prix;
	private Date dateCreation;
	@ManyToOne
	private Categorie categorie;

	public Produit(String nom, Double prix, Date dateCreation, Categorie categorie) {
		super();
		this.nom = nom;
		this.prix = prix;
		this.dateCreation = dateCreation;
		this.categorie = categorie;
	}

	@Override
	public String toString() {
		return "Produit [id=" + id + ", nom=" + nom + ", prix=" + prix + ", dateCreation=" + dateCreation + ", "
				+ categorie + "]";
	}

}
