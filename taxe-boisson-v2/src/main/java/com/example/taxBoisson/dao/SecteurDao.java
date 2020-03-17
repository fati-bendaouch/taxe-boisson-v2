package com.example.taxBoisson.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.taxBoisson.bean.Secteur;
@Repository
public interface SecteurDao  extends JpaRepository<Secteur, Long>{
public Secteur findByNom(String nom);
public int deleteByNom(String nom);
}
