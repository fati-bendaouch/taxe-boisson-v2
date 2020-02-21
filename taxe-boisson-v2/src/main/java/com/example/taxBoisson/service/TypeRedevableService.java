package com.example.taxBoisson.service;

import java.util.List;

import com.example.taxBoisson.bean.TypeRedevable;

public interface TypeRedevableService {
public TypeRedevable findByLibelle(String libelle);
public void save(TypeRedevable typeRedevable);
public List<TypeRedevable> findAll();	
}
