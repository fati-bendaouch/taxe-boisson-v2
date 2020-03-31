package com.example.taxBoisson.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.taxBoisson.bean.Locale;

@Repository
public interface  LocalDao extends JpaRepository<Locale ,Long> {
	public  Locale findByReference(String reference);
	public List<Locale> findByRueNom(String nom);
	public List<Locale> findByRueNomAndCategorieLibelle(String nom,String libelle);
	public List<Locale> findByRueQuartierNomAndCategorieLibelle(String nom,String libelle);
	public List<Locale> findByRueQuartierSecteurNomAndCategorieLibelle(String nom,String libelle);
	public List<Locale> findByDernierTrimPayeBetweenAndDernierAnneePayeBetween(int trimMin,int trimMax,int anneeMin, int anneeMax);
	public List<Locale> findByDernierTrimPaye(int dernierTrimPaye);
	
	public int deleteByReference(String reference);
	@Query(value="select * from locale where (dernier_trim_paye<:trim and dernier_annee_paye = :annee) or (dernier_annee_paye<:annee and dernier_trim_paye>=:trim) or (dernier_annee_paye+1<:annee)",nativeQuery = true)
	public List<Locale> findByDernierTrimPayerAndDernierAnneePayer(@Param(value = "trim") int trim,@Param(value = "annee") int annee);
}
