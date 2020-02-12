package com.example.taxBoisson.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.taxBoisson.bean.Categorie;
@Repository
public interface CategorieDao extends JpaRepository<Categorie, Long>{
public	Categorie findByLibelle(String libelle);

}
