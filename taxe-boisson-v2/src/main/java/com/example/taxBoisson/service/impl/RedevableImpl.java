package com.example.taxBoisson.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.taxBoisson.bean.Redevable;
import com.example.taxBoisson.dao.RedevableDao;
import com.example.taxBoisson.service.RedevableService;

@Service
public class RedevableImpl implements RedevableService {
	@Autowired
	public RedevableDao redevableDao;

	@Override
	public Redevable findByIdentifiant(String identifiant) {
		// TODO Auto-generated method stub
		return redevableDao.findByIdentientant(identifiant);
	}

	@Override
	public List<Redevable> findAll() {
		// TODO Auto-generated method stub
		return redevableDao.findAll();
	}

	@Override
	public void save(Redevable redevable) {
		redevableDao.save(redevable);
		
	}
	

}
