package com.example.taxBoisson.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.taxBoisson.bean.Categorie;
import com.example.taxBoisson.bean.TauxTaxeBoisson;
import com.example.taxBoisson.dao.CategorieDao;
import com.example.taxBoisson.dao.TauxTaxeBoissonDao;
import com.example.taxBoisson.service.facade.CategorieService;
import com.example.taxBoisson.service.facade.TauxTaxeBoissonService;

@Service
public class CategorieImpul implements CategorieService{
	@Autowired
	public CategorieDao categorieDao;
	@Autowired
	 private TauxTaxeBoissonService tauxTaxeBoisson;
	
	@Override
	public List<Categorie> findByLibelle(String libelle) {
		return categorieDao.findByLibelle(libelle);
	}
	@Override
public int save (Categorie categorie ) {
		if(categorieDao.findByLibelle(categorie.getLibelle())!=null){
			return -1;
		}else {
			
		 categorieDao.save(categorie);
		 return 1;
		}
	}
	
	@Override
	public List<Categorie> findAll(){
		return categorieDao.findAll();
	}
	
	
		
		
		
	}


