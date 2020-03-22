package com.example.taxBoisson.service.facade;

import com.example.taxBoisson.bean.TaxeBoisson;

public interface  TaxeBoissonService {
	public TaxeBoisson simulation(TaxeBoisson taxeBoisson);
	public int save(TaxeBoisson taxeBoisson);
	public  int saveOrSimuler(TaxeBoisson taxeBoisson,boolean simuler);

}
