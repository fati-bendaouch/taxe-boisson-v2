package com.example.taxBoisson.service;

import java.util.List;

import com.example.taxBoisson.bean.Quartier;

public interface QuartierService {
	public Quartier findByNom(String nom); 
public int  save(Quartier quartier);
List<Quartier> findAll();
}
