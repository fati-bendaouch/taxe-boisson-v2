package com.example.taxBoisson.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.taxBoisson.bean.Redevable;
@Repository
public interface RedevableDao extends JpaRepository<Redevable, Long> {
	public Redevable findByIdentientant(String identientant );

}
