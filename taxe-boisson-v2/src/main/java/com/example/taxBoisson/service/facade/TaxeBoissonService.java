package com.example.taxBoisson.service.facade;

import java.util.List;

import com.example.taxBoisson.bean.Locale;
import com.example.taxBoisson.bean.TaxeBoisson;

public interface  TaxeBoissonService {
	public int save(TaxeBoisson taxeBoisson);
	public int simulation(TaxeBoisson taxeBoisson);

	public  int saveOrSimuler(TaxeBoisson taxeBoisson,boolean simuler);
	public List<Locale> findByTrimBetweenAndAnneeBetween(int trimMin,int trimMax,int anneeMin, int anneeMax);
}
