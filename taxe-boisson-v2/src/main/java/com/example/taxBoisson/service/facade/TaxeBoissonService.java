package com.example.taxBoisson.service.facade;

import com.example.taxBoisson.bean.TaxeBoisson;

public interface  TaxeBoissonService {
	public int save(TaxeBoisson taxeBoisson);
	public int simulation(TaxeBoisson taxeBoisson);

	public  int saveOrSimuler(TaxeBoisson taxeBoisson,boolean simuler);

}
