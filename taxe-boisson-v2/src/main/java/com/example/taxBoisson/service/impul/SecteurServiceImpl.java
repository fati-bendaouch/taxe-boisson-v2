package com.example.taxBoisson.service.impul;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public void save(Secteur secteur) {
		// TODO Auto-generated method stub
		sectuerdao.save(secteur);
	}

}
