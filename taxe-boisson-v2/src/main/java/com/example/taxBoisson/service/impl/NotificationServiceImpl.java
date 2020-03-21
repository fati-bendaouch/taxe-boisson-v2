package com.example.taxBoisson.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.taxBoisson.bean.Locale;
import com.example.taxBoisson.bean.Notification;
import com.example.taxBoisson.dao.NotificationDao;
import com.example.taxBoisson.service.facade.LocaleService;
import com.example.taxBoisson.service.facade.NotificationService;
@Service
public class NotificationServiceImpl implements NotificationService{
	@Autowired
	private NotificationDao notificationDao;
	@Autowired
	private LocaleService localeService;

	@Override
	public List<Notification> findByRedevableIdentifiant(String identifiant) {
		return notificationDao.findByRedevableIdentifiant(identifiant);
	}

	@Override
	public List<Notification> findByLocaleReference(String reference) {
		return notificationDao.findByLocaleReference(reference);
	}

	@Override
	public int create(Notification notification) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Notification notification) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Notification notification) {
		// TODO Auto-generated method stub
		return 0;
	}
	
//	double montantParPredictionRue(Locale locale , int anneeMin, int anneeMax, int trimMin, int trimMax){
//		List<Locale> foundedLocalesbyCat = localeService.findByRueNomAndCategorieLibelle(locale.getRue().getNom(), locale.getCategorie().getLibelle());
//		List<Locale> foundedLocalesByCred = localeService.findByDernierTrimPayeBetweenAndDernierAnneePayeBetween(trimMin, trimMax, anneeMin, anneeMax);
//		List<Locale> localeResult= foundedLocalesbyCat.stream().filter(local->foundedLocalesByCred.contains(local)).collect(Collectors.toList());
//		double montantT = 0.0;
//		double montant = 0.0;
//		localeResult.forEach(loc->{
//			montantT = loc.get
//		});
//	}
	

}
