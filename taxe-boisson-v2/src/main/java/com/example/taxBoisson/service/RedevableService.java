package com.example.taxBoisson.service;

import java.util.List;

import com.example.taxBoisson.bean.Redevable;

public interface RedevableService {
	public Redevable findByIdentifiant(String identifiant); 
	public List<Redevable> findAll(); 
	public int save(Redevable redevable); 
		
	
		
	
		
	

}
