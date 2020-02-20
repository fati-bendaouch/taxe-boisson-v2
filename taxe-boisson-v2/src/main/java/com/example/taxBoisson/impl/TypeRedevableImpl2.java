package com.example.taxBoisson.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.taxBoisson.bean.TypeRedevable;
import com.example.taxBoisson.dao.TypeRedevableDao;
import com.example.taxBoisson.service.TypeRedevableService;

@Service 
public class TypeRedevableImpl2 implements TypeRedevableService{
@Autowired
public TypeRedevableDao typeRedevableDao;
	@Override
	public TypeRedevable findByLibelle(String libelle) {
		// TODO Auto-generated method stub
		return typeRedevableDao.findByLibelle(libelle) ;
	}

	@Override
	public void save(TypeRedevable typeRedevable) {
		typeRedevableDao.save(typeRedevable);
		
	}

	@Override
	public List<TypeRedevable> findAll() {
		// TODO Auto-generated method stub
		return typeRedevableDao.findAll();
	}

}
