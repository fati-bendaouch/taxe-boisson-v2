package com.example.taxBoisson.service.facade;

import java.util.List;

import com.example.taxBoisson.bean.Locale;

public interface LocaleService {
	public Locale findByReference(String reference);
	public int  save(Locale locale);
	public List<Locale> findAll();
	public List<Locale> findByRedevabIdentifiant(String identifiant);
	public List<Locale> findByRueNomAndCategorieLibelle(String nom,String libelle);
	public List<Locale> findByRueQuartierNomAndCategorieLibelle(String nom,String libelle);
	public List<Locale> findByRueQuartierSecteurNomAndCategorieLibelle(String nom,String libelle);
	public List<Locale> findByDernierTrimPayeBetweenAndDernierAnneePayeBetween(int trimMin,int trimMax,int anneeMin, int anneeMax);
}
