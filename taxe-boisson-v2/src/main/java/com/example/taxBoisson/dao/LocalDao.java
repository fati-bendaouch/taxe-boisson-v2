package com.example.taxBoisson.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.taxBoisson.bean.Locale;

@Repository
public interface  LocalDao extends JpaRepository<Locale ,Long> {
	public  Locale findByReference(String reference);
}
