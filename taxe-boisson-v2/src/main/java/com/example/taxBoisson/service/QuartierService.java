package com.example.taxBoisson.service;

import java.util.List;

import com.example.taxBoisson.bean.Quartier;

public interface QuartierService {
	public Quartier findByNom(String nom); 
public void save(Quartier quartier);
List<Quartier> findAll();
}
