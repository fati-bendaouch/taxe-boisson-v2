package com.example.taxBoisson.dao;

import org.springframework.cglib.core.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface  LocalDao extends JpaRepository<Local,Long> {

}
