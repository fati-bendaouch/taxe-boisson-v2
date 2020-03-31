package com.example.taxBoisson.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.taxBoisson.bean.Categorie;
import com.example.taxBoisson.bean.Locale;
import com.example.taxBoisson.bean.Notification;
import com.example.taxBoisson.bean.Redevable;
import com.example.taxBoisson.bean.Rue;
import com.example.taxBoisson.bean.TauxTaxeBoisson;
import com.example.taxBoisson.bean.TaxeBoisson;
import com.example.taxBoisson.dao.LocalDao;
import com.example.taxBoisson.dao.NotificationDao;
import com.example.taxBoisson.service.facade.LocaleService;
import com.example.taxBoisson.service.facade.NotificationService;
import com.example.taxBoisson.service.facade.RedevableService;
import com.example.taxBoisson.service.facade.TauxTaxeBoissonService;
import com.example.taxBoisson.service.facade.TaxeBoissonService;
import com.example.taxBoisson.service.util.DateUtil;

@Service
public class NotificationServiceImpl implements NotificationService {
	@Autowired
	private NotificationDao notificationDao;
	@Autowired
	private LocaleService localeService;
	@Autowired
	private TaxeBoissonService taxeBoissonService;
	@Autowired
	private TauxTaxeBoissonService ttbService;
	@Autowired
	private RedevableService redevableService;
	
	@Override
	public List<Notification> findByRedevableIdentifiant(String identifiant) {
		return notificationDao.findByRedevableIdentifiant(identifiant);
	}

	@Override
	public List<Notification> findByLocaleReference(String reference) {
		return notificationDao.findByLocaleReference(reference);
	}

	// la creation d'une notification
	@Override
	public int create(Notification notification) {
	
		Locale loc = localeService.findByReference(notification.getLocale().getReference());
		notification.setLocale(loc);
		Redevable red = redevableService.findByIdentifiant(notification.getRedevable().getIdentifiant());
		notification.setRedevable(red);
		
		if (notification.getTrimMin() == 0 || notification.getTrimMax() == 0 || notification.getAnneeMin() == 0
				|| notification.getAnneeMax() == 0) {
			return -2;
		}
		if (loc == null || red == null) {
			return -1;
		} 
		else {
			TauxTaxeBoisson ttb = ttbService
					.findByCategorieLibelle(notification.getLocale().getCategorie().getLibelle());
			int diffTrim = DateUtil.getDiff(notification.getTrimMin(), notification.getTrimMax(), notification.getAnneeMin(), notification.getAnneeMax());
			double montantBase = notifier(notification);
			double montantWithDiff = montantBase * diffTrim;
			notification.setMontantBase(montantWithDiff);
			
			notification.setProfit(montantWithDiff - ttb.getPourcentageBase() * montantWithDiff);
			
			notification.setMoisRetard(DateUtil.calcDiffMois(notification.getLocale().getDernierTrimPaye(),
					notification.getLocale().getDernierAnneePaye(),DateUtil.constructDate(notification.getTrimMax(), notification.getAnneeMax())));
			
			notification.setMontantRetard(montantBase * ttb.getPourcentageRetard());
			notification.setMontantTotale(notification.getMontantBase() + notification.getMontantRetard());
			notificationDao.save(notification);
			return 1;
		}
	}
	@Transactional
	@Override
	public int delete(Notification notification) {
		Notification foundedNotification = notificationDao.findById(notification.getId()).get();
		if(foundedNotification == null){
			return -1;
		}else {
			notificationDao.delete(foundedNotification);
			return 1;
		}
	}

	@Override
	public int update(Notification notification) {
		Notification foundedNotification = notificationDao.findById(notification.getId()).get();
		if(foundedNotification == null){
			return -1;
		}else {
			notificationDao.save(foundedNotification);
			return 1;
		}
	}

	// cette methode est charger pour chercher les voisin d'un locale de meme
	// categorie
	double notifier(Notification notification) {
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
		foundedLocs.forEach(loc->System.out.println(loc));
		return chargerUnMontant(foundedLocs, notification.getAnneeMin(), notification.getAnneeMax(),
				notification.getTrimMin(), notification.getTrimMax());
	}

	// cette methode est charger a calculer le montant charger au locale
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

// creation d'une list de notification
	@Override
	public void notifierTout(int trimMin, int trimMax, int anneeMin, int anneeMax) {
		List<Locale> localesANotifier = localeService.findByDernierTrimPayeBetweenAndDernierAnneePayeBetween(trimMin,
				trimMax, anneeMin, anneeMax);
		List<Locale> listLocaleNotToNotif =localeService.findByDernierTrimPaye(trimMax);
		List<Locale> localeResult = localesANotifier.stream().filter(locale->!listLocaleNotToNotif.contains(locale)).collect(Collectors.toList());
		ArrayList<Notification> notifications = new ArrayList<Notification>();
		for (Locale locale : localeResult) {
			Notification notification = new Notification();
			notification.setLocale(locale);
			notification.setRedevable(locale.getRedevable());
			notification.setTrimMin(trimMin);
			notification.setTrimMax(trimMax);
			notification.setAnneeMin(anneeMin);
			notification.setAnneeMax(anneeMax);
			notifications.add(notification);
		}
		for (Notification notification : notifications) {
			create(notification);
		}

	}

	@Override
	public List<Notification> findAll() {
		return notificationDao.findAll();
	}

}
