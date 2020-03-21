package com.example.taxBoisson.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.taxBoisson.bean.Notification;
@Repository
public interface NotificationDao  extends JpaRepository<Notification, Long>{
	
	List<Notification> findByRedevableIdentifiant(String identifiant);
	List<Notification> findByLocaleReference(String reference);
	
}
