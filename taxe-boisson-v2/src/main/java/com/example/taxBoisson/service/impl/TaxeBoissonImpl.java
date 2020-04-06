package com.example.taxBoisson.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.taxBoisson.bean.Locale;
import com.example.taxBoisson.bean.Redevable;
import com.example.taxBoisson.bean.TauxTaxeBoisson;
import com.example.taxBoisson.bean.TaxeBoisson;
import com.example.taxBoisson.dao.LocalDao;
import com.example.taxBoisson.dao.RedevableDao;
import com.example.taxBoisson.dao.TauxTaxeBoissonDao;
import com.example.taxBoisson.dao.TaxeBoissonDao;
import com.example.taxBoisson.service.facade.LocaleService;
import com.example.taxBoisson.service.facade.TaxeBoissonService;
import com.example.taxBoisson.service.util.DateUtil;

@Service
public class TaxeBoissonImpl implements TaxeBoissonService {
	@Autowired
	private TaxeBoissonDao taxeBoissonDao;

	@Autowired
	private RedevableDao redevableService;

	@Autowired
	private TauxTaxeBoissonDao tauxTaxeBoissonDao;
	
	@Autowired
	private LocaleService localeService;
	
	public int saveOrSimuler(TaxeBoisson taxeBoisson, boolean simuler) {
		Locale locale = localeService.findByReference(taxeBoisson.getLocale().getReference());
		Redevable redevable = redevableService.findByIdentifiant(taxeBoisson.getRedevable().getIdentifiant());
		if (locale == null) {
			return -1;
		} else if (redevable == null) {
			return -3;
		}
		TauxTaxeBoisson tauxTaxeBoisson = tauxTaxeBoissonDao.findByCategorieId(locale.getCategorie().getId());
		System.out.println("getCategorie +===" + locale.getCategorie().getId());
		if (tauxTaxeBoisson == null) {
			return -2;
		} else {
			taxeBoisson.setMoisRetard(DateUtil.calcDiffMois(taxeBoisson.getTrim(), taxeBoisson.getAnnee(),
			taxeBoisson.getDatePresentation()));
			taxeBoisson.setTrim(taxeBoisson.getTrim());
			taxeBoisson.setAnnee(taxeBoisson.getAnnee());
			taxeBoisson.setProfit(taxeBoisson.getProfit());
			taxeBoisson.setLocale(locale);
			taxeBoisson.setRedevable(redevable);
			taxeBoisson.setTauxTaxeBoisson(tauxTaxeBoisson);
			taxeBoisson.setMontantBase(taxeBoisson.getTauxTaxeBoisson().getPourcentageBase() * taxeBoisson.getProfit());
			taxeBoisson.setMontantRetard(
			taxeBoisson.getTauxTaxeBoisson().getPourcentageRetard() * taxeBoisson.getProfit());
			taxeBoisson.setMontantTotale(taxeBoisson.getMontantBase() + taxeBoisson.getMontantRetard());
			if (simuler == false) {
				taxeBoissonDao.save(taxeBoisson);
				return 1;
			} else {
				return 2;
			}
		}
	}

	public int save(TaxeBoisson taxeBoisson) {
		return saveOrSimuler(taxeBoisson, false);
	}



	@Override
	public List<TaxeBoisson> findByTrimBetweenAndAnneeBetween(int trimMin, int trimMax, int anneeMin, int anneeMax) {
		return taxeBoissonDao.findByTrimBetweenAndAnneeBetween(trimMin, trimMax, anneeMin, anneeMax);
	}

	@Override 
	public TaxeBoisson simulation(TaxeBoisson taxeBoisson) {
		saveOrSimuler(taxeBoisson, true);
		return taxeBoisson;
	}

	@Override
	public List<TaxeBoisson> findByLocaleReference(String reference) {
		List<Locale> loc = localeService.findAll();
		System.out.println(loc);
		return taxeBoissonDao.findByLocaleReference(reference);
	}
	@Transactional
	@Override
	public void deleteByLocaleReference(String reference) {
		 taxeBoissonDao.deleteByLocaleReference(reference);
		
	}
}
	