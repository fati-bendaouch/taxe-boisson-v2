package com.example.taxBoisson.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.taxBoisson.bean.Rue;

@Repository 
public interface RueDao extends JpaRepository<Rue, Long> {
public  Rue findByNom(String nom);
int deleteByNom(String nom);
public List<Rue> findByQuartierNom(String nom);

}
