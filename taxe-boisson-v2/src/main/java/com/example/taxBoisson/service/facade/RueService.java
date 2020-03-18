package com.example.taxBoisson.service.facade;

import java.util.List;

import com.example.taxBoisson.bean.Rue;
public interface RueService {
	public int save(Rue rue);
	public  Rue findByNom(String nom);
	public List<Rue> findAll();
	public int deleteByNom( String nom) ;
	public int find(String rue, String redevable);
	
}
