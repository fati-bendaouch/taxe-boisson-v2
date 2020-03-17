package com.example.taxBoisson.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.taxBoisson.bean.Quartier;
import com.example.taxBoisson.dao.QuartierDao;
import com.example.taxBoisson.service.facade.QuartierService;

@Service
public class QuartierServiceImpl implements QuartierService{
	@Autowired
	private QuartierDao quartierdao;

	@Override
	public Quartier findByNom(String nom) {
		// TODO Auto-generated method stub
		return quartierdao.findByNom(nom);
	}

	@Override
	public void save(Quartier quartier) {
		// TODO Auto-generated method stub
		quartierdao.save(quartier);
	}

	@Override
	public List<Quartier> findAll() {
		// TODO Auto-generated method stub
		return quartierdao.findAll();
	}
	

}
