package com.spring.produits.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProduitDTO {
	private Long id;
	private String nom;
	private Double prix;
	private Date dateCreation;
	private String description;
	//private Categorie categorie;	
}