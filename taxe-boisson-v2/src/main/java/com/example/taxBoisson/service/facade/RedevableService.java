package com.example.taxBoisson.service.facade;

import java.util.List;

import com.example.taxBoisson.bean.Redevable;

public interface RedevableService {
public Redevable findByIdentifiant(String identifiant);
public List<Redevable> findAll();
public int save(Redevable redevable);
}