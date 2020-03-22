package com.example.taxBoisson.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.taxBoisson.bean.TypeRedevable;

@Repository
public interface TypeRedevableDao extends JpaRepository<TypeRedevable, Long>{
	public TypeRedevable findByLibelle(String libelle);
   public int deleteByLibelle(String libelle);
}
