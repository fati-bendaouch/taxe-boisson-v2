package com.example.taxBoisson.service.facade;

import java.util.List;

import com.example.taxBoisson.bean.Notification;

public interface NotificationService {
	
	List<Notification> findByRedevableIdentifiant(String identifiant);
	List<Notification> findByLocaleReference(String reference);
	int create(Notification notification);
	int delete(Notification notification);
	int update(Notification notification);
	void notifierTout(int trimMin,int trimMax, int anneeMin, int anneeMax);
	List<Notification> findAll();
	
}
