package com.example.taxBoisson.service;

import java.util.List;

import com.example.taxBoisson.bean.Secteur;

public interface SecteurService {
	public Secteur findByNom(String nom);
	public int save(Secteur secteur);
	public List<Secteur>findAll();
	
	public int deleteByNom(String nom);

}
