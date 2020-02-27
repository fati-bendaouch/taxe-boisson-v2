package com.example.taxBoisson.service;

import java.util.List;

import com.example.taxBoisson.bean.Categorie;

public interface CategorieService {
public Categorie findByLibelle(String libelle);
public int  save(Categorie categorie);
public List<Categorie> findAll();

 	
	
	
	
}
