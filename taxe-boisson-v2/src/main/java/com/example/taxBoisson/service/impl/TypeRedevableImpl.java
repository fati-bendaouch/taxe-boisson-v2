package com.example.taxBoisson.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.taxBoisson.bean.Redevable;
import com.example.taxBoisson.bean.TypeRedevable;
import com.example.taxBoisson.dao.TypeRedevableDao;
import com.example.taxBoisson.service.facade.RedevableService;
import com.example.taxBoisson.service.facade.TypeRedevableService;




@Service 
public class TypeRedevableImpl implements TypeRedevableService{
@Autowired
public TypeRedevableDao typeRedevableDao;
@Autowired
RedevableService redevableService;
	@Override
	public TypeRedevable findByLibelle(String libelle) {
		// TODO Auto-generated method stub
		return typeRedevableDao.findByLibelle(libelle) ;
	}

	@Override
	public int save(TypeRedevable typeRedevable) {
		if(findByLibelle(typeRedevable.getLibelle())!=null)
			return -1;
		else {
			typeRedevableDao.save(typeRedevable);
			return 1;
		}
		
		
	}

	@Override
	public List<TypeRedevable> findAll() {
		// TODO Auto-generated method stub
		return typeRedevableDao.findAll();
	}

	
}
