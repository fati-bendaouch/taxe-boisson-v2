package com.example.taxBoisson.service;

import com.example.taxBoisson.bean.Secteur;

public interface SecteurService {
	public Secteur findByNom(String nom);
	public void save(Secteur secteur);

}
