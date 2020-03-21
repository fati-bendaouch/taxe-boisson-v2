package com.example.taxBoisson.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.taxBoisson.bean.Locale;

@Repository
public interface  LocalDao extends JpaRepository<Locale ,Long> {
	public  Locale findByReference(String reference);
	
	public List<Locale> findByRueNomAndCategorieLibelle(String nom,String libelle);
	public List<Locale> findByRueQuartierNomAndCategorieLibelle(String nom,String libelle);
	public List<Locale> findByRueQuartierSecteurNomAndCategorieLibelle(String nom,String libelle);
	public List<Locale> findByDernierTrimPayeBetweenAndDernierAnneePayeBetween(int trimMin,int trimMax,int anneeMin, int anneeMax);

}
