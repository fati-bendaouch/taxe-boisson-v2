package com.example.taxBoisson.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.taxBoisson.bean.TaxeBoisson;

@Repository

public interface  TaxeBoissonDao extends JpaRepository<TaxeBoisson, Long> {
	
	

}
