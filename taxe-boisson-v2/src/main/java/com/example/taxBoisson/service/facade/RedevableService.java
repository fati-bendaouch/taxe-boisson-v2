package com.example.taxBoisson.service.facade;

import java.util.List;

import com.example.taxBoisson.bean.Redevable;

public interface RedevableService {
	
	public List<Redevable> findByQuartier(String nom);
	public List<Redevable> findByTypeRedevable(String libelle);
	public int save(Redevable redevable);
	public List<Redevable> findAll();
	public Redevable findByIdentifiant(String identifiant);
		

}
