package com.example.taxBoisson.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.taxBoisson.bean.Rue;
import com.example.taxBoisson.dao.RueDao;
import com.example.taxBoisson.service.RueService;

@Service
public class RueServiceImpl implements RueService{
	@Autowired
private RueDao ruedao;
	@Override
	public int save(Rue rue) {
		// TODO Auto-generated method stub
		if(findByNom(rue.getNom())!=null)
			return -1;
		else {
		ruedao.save(rue);
		return 1;
	}}

	@Override
	public Rue findByNom(String nom) {
		// TODO Auto-generated method stub
		return ruedao.findByNom(nom);
	}

}
