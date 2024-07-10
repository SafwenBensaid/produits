package com.spring.produits.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.produits.dto.ProduitDTO;
import com.spring.produits.entities.Categorie;
import com.spring.produits.entities.Produit;
import com.spring.produits.repos.ProduitRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProduitServiceImpl implements ProduitService {

	@Autowired
	ProduitRepository produitRepository;

	@Autowired
	ModelMapper modelMapper;

	@Override
	public ProduitDTO convertEntityToDto(Produit produit) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		return modelMapper.map(produit, ProduitDTO.class);
	}

	@Override
	public Produit convertDtoToEntity(ProduitDTO produitDto) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		return modelMapper.map(produitDto, Produit.class);
	}

	@Override
	public ProduitDTO saveProduit(ProduitDTO p) {
		return convertEntityToDto(produitRepository.save(convertDtoToEntity(p)));
	}

	@Override
	public ProduitDTO updateProduit(ProduitDTO p) {
		return convertEntityToDto(produitRepository.save(convertDtoToEntity(p)));
	}

	@Override
	public void deleteProduit(ProduitDTO p) {
		produitRepository.delete(convertDtoToEntity(p));
	}

	@Override
	public void deleteProduitById(Long id) {
		produitRepository.deleteById(id);
	}

	@Override
	public ProduitDTO getProduit(Long id) {
		return convertEntityToDto(produitRepository.findById(id).get());
	}

	@Override
	public List<ProduitDTO> getAllProduits() {
		return produitRepository.findAll().stream().map(this::convertEntityToDto).collect(Collectors.toList());
	}

	@Override
	public List<ProduitDTO> findByNom(String nom) {
		return produitRepository.findByNom(nom).stream().map(this::convertEntityToDto).collect(Collectors.toList());
	}

	@Override
	public List<ProduitDTO> findByDateCreationBeforeOrderByPrixDesc(Date dateCreation) {
		return produitRepository.findByDateCreationBeforeOrderByPrixDesc(dateCreation).stream()
				.map(this::convertEntityToDto).collect(Collectors.toList());
	}

	@Override
	public List<ProduitDTO> findByNomPrix(String nom, Double prix) {
		return produitRepository.findByNomPrix(nom, prix).stream().map(this::convertEntityToDto)
				.collect(Collectors.toList());
	}

	@Override
	public List<ProduitDTO> findByCategorie(Categorie categorie) {
		return produitRepository.findByCategorie(categorie).stream().map(this::convertEntityToDto)
				.collect(Collectors.toList());
	}

	@Override
	public List<ProduitDTO> findByCategorieId(Long id) {
		return produitRepository.findByCategorieId(id).stream().map(this::convertEntityToDto)
				.collect(Collectors.toList());
	}

	@Override
	public List<ProduitDTO> findByCategorieNom(String nom) {
		return produitRepository.findByCategorieNom(nom).stream().map(this::convertEntityToDto)
				.collect(Collectors.toList());
	}

	@Override
	public List<ProduitDTO> findByOrderByNomAsc() {
		return produitRepository.findByOrderByNomAsc().stream().map(this::convertEntityToDto)
				.collect(Collectors.toList());
	}

	@Override
	public List<ProduitDTO> trierProduitsNomsPrix() {
		return produitRepository.trierProduitsNomsPrix().stream().map(this::convertEntityToDto)
				.collect(Collectors.toList());
	}

}
