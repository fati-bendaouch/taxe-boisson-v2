package com.example.taxBoisson.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.taxBoisson.bean.Categorie;
import com.example.taxBoisson.dao.CategorieDao;
import com.example.taxBoisson.service.CategorieService;

@Service
public class CategorieImpul implements CategorieService{
	@Autowired
	public CategorieDao categorieDao;
	@Override
	public Categorie findByLibelle(String libelle) {
		return categorieDao.findByLibelle(libelle);
	}
	@Override
	public void save (Categorie categorie) {
		 categorieDao.save(categorie);
		
	}
	@Override
	public List<Categorie> findAll(){
		return categorieDao.findAll();
	}

}
