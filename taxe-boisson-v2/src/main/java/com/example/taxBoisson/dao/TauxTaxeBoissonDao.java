package com.example.taxBoisson.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.taxBoisson.bean.TauxTaxeBoisson;
@Repository
public interface TauxTaxeBoissonDao extends JpaRepository<TauxTaxeBoisson, Long>{
	public TauxTaxeBoisson findByCategorieLibelle(String libelle) ;
	public int deleteByCategorieLibelle(String libelle);
	public TauxTaxeBoisson findByCategorieId(Long id);


}
