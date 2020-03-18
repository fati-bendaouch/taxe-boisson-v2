package com.example.taxBoisson.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.taxBoisson.bean.Quartier;
import com.example.taxBoisson.bean.Secteur;
import com.example.taxBoisson.dao.QuartierDao;
import com.example.taxBoisson.service.QuartierService;
import com.example.taxBoisson.service.SecteurService;

@Service
public class QuartierServiceImpl implements QuartierService{
	@Autowired
	private QuartierDao quartierdao;
	@Autowired
	private SecteurService secteurService;

	@Override
	public Quartier findByNom(String nom) {
		// TODO Auto-generated method stub
		return quartierdao.findByNom(nom);
	}

	@Override
	public int save(Quartier quartier) {
		// TODO Auto-generated method stub
		if(findByNom(quartier.getNom())!=null) {
			return -1;
		}
		else {

		if(findByNom(quartier.getNom())!=null)
			return -1;
		else
		quartierdao.save(quartier);
		return 1;
	}}
	

	@Override
	public List<Quartier> findAll() {
		// TODO Auto-generated method stub
		return quartierdao.findAll();
	}
	@Override
	public List<Quartier> findBySecteurNom(String nom) {
		Secteur secteur=secteurService.findByNom(nom);
		List<Quartier>quartiers=findAll();
		List<Quartier>quartiers2=new ArrayList<Quartier>();
		for(Quartier quartier:quartiers) {
			if(quartier.getSecteur()==secteur)
				quartiers2.add(quartier);
		}
		return quartiers2;

}

}
