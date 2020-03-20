package com.example.taxBoisson.service.facade;

import java.util.List;

import com.example.taxBoisson.bean.Quartier;

public interface QuartierService {
public Quartier findByNom(String nom);
List<Quartier> findAll();
public int save(Quartier quartier);
public List<Quartier> findBySecteurNom(String nom);
public int deleteByNom(String nom);

}
