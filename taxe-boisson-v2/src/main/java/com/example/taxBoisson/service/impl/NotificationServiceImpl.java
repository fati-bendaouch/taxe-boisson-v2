package com.example.taxBoisson.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.taxBoisson.bean.Categorie;
import com.example.taxBoisson.bean.Locale;
import com.example.taxBoisson.bean.Notification;
import com.example.taxBoisson.bean.Rue;
import com.example.taxBoisson.bean.TaxeBoisson;
import com.example.taxBoisson.dao.NotificationDao;
import com.example.taxBoisson.service.facade.LocaleService;
import com.example.taxBoisson.service.facade.NotificationService;
import com.example.taxBoisson.service.facade.TaxeBoissonService;

@Service
public class NotificationServiceImpl implements NotificationService {
	@Autowired
	private NotificationDao notificationDao;
	@Autowired
	private LocaleService localeService;
	@Autowired
	private TaxeBoissonService taxeBoissonService;

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
		double montatCalculer = Notifier(notification);
		return 1;

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

	double Notifier(Notification notification) {
		Categorie cat = notification.getLocale().getCategorie();
		Rue rue = notification.getLocale().getRue();
		List<Locale> foundedLocs = localeService.findByRueNomAndCategorieLibelle(rue.getNom(), cat.getLibelle());
		if (foundedLocs.size() == 0) {
			foundedLocs = localeService.findByRueQuartierNomAndCategorieLibelle(rue.getQuartier().getNom(),
					cat.getLibelle());

		}
		if (foundedLocs.size() == 0) {
			foundedLocs = localeService.findByRueQuartierSecteurNomAndCategorieLibelle(
					rue.getQuartier().getSecteur().getNom(), cat.getLibelle());
		}

		return chargerUnMontant(foundedLocs, notification.getAnneeMin(), notification.getAnneeMax(),
				notification.getTrimMin(), notification.getTrimMax());
	}

	double chargerUnMontant(List<Locale> locales, int anneeMin, int anneeMax, int trimMin, int trimMax) {
		List<Locale> foundedLocalesByCred = localeService
				.findByDernierTrimPayeBetweenAndDernierAnneePayeBetween(trimMin, trimMax, anneeMin, anneeMax);
		List<Locale> localeResult = locales.stream().filter(local -> foundedLocalesByCred.contains(local))
				.collect(Collectors.toList());
		double montantT = 0.0;
		double montant = 0.0;
		List<TaxeBoisson> taxeBoissons = taxeBoissonService.findByTrimBetweenAndAnneeBetween(trimMin, trimMax, anneeMin,
				anneeMax);
		List<TaxeBoisson> taxeBoissonResult = taxeBoissons.stream()
				.filter(taxe -> localeResult.contains(taxe.getLocale())).collect(Collectors.toList());
		for (TaxeBoisson taxe : taxeBoissonResult) {
			montant += taxe.getMontantBase();
		}
		montantT = montant / taxeBoissonResult.size();
		return montantT;
	}

}
