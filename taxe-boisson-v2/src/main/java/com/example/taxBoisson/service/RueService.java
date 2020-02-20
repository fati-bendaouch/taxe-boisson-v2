package com.example.taxBoisson.service;

import com.example.taxBoisson.bean.Rue;

public interface RueService {
	public void save(Rue rue);
	public  Rue findByNom(String nom);

}
