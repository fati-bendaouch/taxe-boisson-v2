package com.example.taxBoisson.service.facade;

import java.util.List;

import com.example.taxBoisson.bean.Categorie;

public interface CategorieService {
public int save (Categorie categorie);
public List<Categorie> findAll();
public List<Categorie> findByLibelle(String libelle);

 	
	
	
	
}
