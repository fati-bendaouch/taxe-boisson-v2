package com.example.taxBoisson.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.taxBoisson.bean.Quartier;

@Repository
public interface QuartierDao extends JpaRepository<Quartier, Long> {
public Quartier findByNom(String Nom);
}
