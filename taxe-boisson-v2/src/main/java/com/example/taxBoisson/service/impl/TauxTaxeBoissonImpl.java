package com.example.taxBoisson.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.taxBoisson.bean.Categorie;
import com.example.taxBoisson.bean.TauxTaxeBoisson;
import com.example.taxBoisson.dao.TauxTaxeBoissonDao;
import com.example.taxBoisson.service.facade.CategorieService;
import com.example.taxBoisson.service.facade.TauxTaxeBoissonService;
@Service
public class TauxTaxeBoissonImpl implements TauxTaxeBoissonService {
	@Autowired
	private TauxTaxeBoissonDao tauxTaxeBoissonDao;
    @Autowired
    private CategorieService categorieService;
	
@Override
	public void save(Categorie categorie,List<TauxTaxeBoisson> tauxTaxeBoissons) {
		for(int i=0;i< tauxTaxeBoissons.size();i++ ) {
			TauxTaxeBoisson taux= tauxTaxeBoissons.get(i);
			taux.setCategorie(categorie);
			tauxTaxeBoissonDao.save(taux);
		}
		
		
	}

}
