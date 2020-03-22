package com.example.taxBoisson.dao;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.taxBoisson.bean.Redevable;
@Repository
public interface RedevableDao extends JpaRepository<Redevable, Long> {
	
public Redevable findByIdentifiant(String identifiant );
public List<Redevable> findByTypeRedevable(String libelle);
public int deleteByIdentifiant(String identifiant);
}
