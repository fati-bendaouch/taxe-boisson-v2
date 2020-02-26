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
		return redevableDao.findByIdentifiant(identifiant);
	}

	@Override
	public List<Redevable> findAll() {
		// TODO Auto-generated method stub
		return redevableDao.findAll();
	}

	@Override
	public int save(Redevable redevable) {
		if(findByIdentifiant(redevable.getIdentifiant())!=null)
			return -1;
		else {
			redevableDao.save(redevable);
			return 1;
			} 
			
		
	}
	

}
