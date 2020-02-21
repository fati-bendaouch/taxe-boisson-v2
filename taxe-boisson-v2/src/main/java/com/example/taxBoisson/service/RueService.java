package com.example.taxBoisson.service;

import com.example.taxBoisson.bean.Rue;
public interface RueService {
	public int save(Rue rue);
	public  Rue findByNom(String nom);
}
