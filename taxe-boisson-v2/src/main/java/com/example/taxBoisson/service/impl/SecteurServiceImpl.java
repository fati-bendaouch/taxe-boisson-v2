package com.example.taxBoisson.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.taxBoisson.bean.Secteur;
import com.example.taxBoisson.dao.SecteurDao;
import com.example.taxBoisson.service.SecteurService;

@Service
public class SecteurServiceImpl implements SecteurService {
@Autowired
	private SecteurDao sectuerdao;
	@Override
	public Secteur findByNom(String nom) {
		// TODO Auto-generated method stub
		return	 sectuerdao.findByNom(nom);
		 
	}

	
	
	@Override
	public int  save(Secteur secteur) {
		// TODO Auto-generated method stub
if(findByNom(secteur.getNom())!=null) {return -1;

}
else 
		sectuerdao.save(secteur);
return 1;
	}

	@Override
	public List<Secteur> findAll() {
		// TODO Auto-generated method stub
		return sectuerdao.findAll();
	}
@Transactional
	@Override
	public int deleteByNom(String nom) {
		return sectuerdao.deleteByNom(nom);
	}

}
