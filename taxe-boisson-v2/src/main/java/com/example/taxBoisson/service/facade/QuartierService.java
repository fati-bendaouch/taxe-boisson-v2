package com.example.taxBoisson.service.facade;

import java.util.List;

import com.example.taxBoisson.bean.Quartier;

public interface QuartierService {
public Quartier findByNom(String nom); 
List<Quartier> findAll();
public List<Quartier> findBySecteurNom(String nom);
public int save(Quartier quartier);
}
