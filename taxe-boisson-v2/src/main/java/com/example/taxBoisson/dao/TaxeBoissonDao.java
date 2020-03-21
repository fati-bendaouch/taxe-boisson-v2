package com.example.taxBoisson.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.taxBoisson.bean.Locale;
import com.example.taxBoisson.bean.TaxeBoisson;

@Repository

public interface  TaxeBoissonDao extends JpaRepository<TaxeBoisson, Long> {
	
	public List<Locale> findByTrimBetweenAndAnneeBetween(int trimMin,int trimMax,int anneeMin, int anneeMax);

}
