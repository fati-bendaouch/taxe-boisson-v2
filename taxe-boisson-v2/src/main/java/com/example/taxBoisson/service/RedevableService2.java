package com.example.taxBoisson.service;

import java.util.List;

import com.example.taxBoisson.bean.Redevable;

public interface RedevableService2 {
	public Redevable findByIdentientant(String identientant); 
	public List<Redevable> findAll(); 
	public void save(Redevable redevable); 
		
	
		
	
		
	

}
