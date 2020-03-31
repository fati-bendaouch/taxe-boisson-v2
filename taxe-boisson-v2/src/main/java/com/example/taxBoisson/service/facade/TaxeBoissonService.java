package com.example.taxBoisson.service.facade;

import java.util.List;

import com.example.taxBoisson.bean.TaxeBoisson;

public interface  TaxeBoissonService {
	public TaxeBoisson simulation(TaxeBoisson taxeBoisson);
	public int save(TaxeBoisson taxeBoisson);
	public  int saveOrSimuler(TaxeBoisson taxeBoisson,boolean simuler);
	public List<TaxeBoisson> findByTrimBetweenAndAnneeBetween(int trimMin,int trimMax,int anneeMin, int anneeMax);
	public List<TaxeBoisson> findByLocaleReference(String reference);
}
