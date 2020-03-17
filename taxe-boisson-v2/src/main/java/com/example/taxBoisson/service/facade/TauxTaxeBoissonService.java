package com.example.taxBoisson.service.facade;

import java.util.List;

import com.example.taxBoisson.bean.Categorie;
import com.example.taxBoisson.bean.TauxTaxeBoisson;

public interface  TauxTaxeBoissonService {
	public void save(Categorie categorie,List<TauxTaxeBoisson> tauxTaxeBoisson);

}
