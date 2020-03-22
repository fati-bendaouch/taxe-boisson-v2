package com.example.taxBoisson.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.taxBoisson.bean.Locale;
import com.example.taxBoisson.bean.Redevable;
import com.example.taxBoisson.bean.TauxTaxeBoisson;
import com.example.taxBoisson.bean.TaxeBoisson;
import com.example.taxBoisson.dao.LocalDao;
import com.example.taxBoisson.dao.RedevableDao;
import com.example.taxBoisson.dao.TauxTaxeBoissonDao;
import com.example.taxBoisson.dao.TaxeBoissonDao;
import com.example.taxBoisson.service.facade.CategorieService;
import com.example.taxBoisson.service.facade.LocaleService;
import com.example.taxBoisson.service.facade.RedevableService;
import com.example.taxBoisson.service.facade.TauxTaxeBoissonService;
import com.example.taxBoisson.service.facade.TaxeBoissonService;
import com.example.taxBoisson.service.util.DateUtil;

@Service
public class TaxeBoissonImpl implements TaxeBoissonService {
	@Autowired
	private TaxeBoissonDao taxeBoissonDao;

	@Autowired
	private LocalDao localedao;

	@Autowired
	private RedevableDao redevableDao;

	@Autowired
	private TauxTaxeBoissonDao tauxTaxeBoissonDao;

	@Autowired
	private LocaleService localeService;
	@Autowired
	private RedevableService redevableService;
	@Autowired
	private TauxTaxeBoissonService tauxTaxeBoissonService;
	@Autowired
	private CategorieService categorieService;

	public int saveOrSimuler(TaxeBoisson taxeBoisson, boolean simuler) {
		Locale locale = localedao.getOne(taxeBoisson.getLocale().getId());
		Redevable redevable = redevableDao.getOne(taxeBoisson.getRedevable().getId());

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
			if (!simuler)
				taxeBoissonDao.save(taxeBoisson);
			return 1;
		}
	}

	public int save(TaxeBoisson taxeBoisson) {
		return saveOrSimuler(taxeBoisson, false);
	}

	@Override
	public int simulation(TaxeBoisson taxeBoisson) {
		return saveOrSimuler(taxeBoisson, true);
	}

	@Override
	public List<TaxeBoisson> findByTrimBetweenAndAnneeBetween(int trimMin, int trimMax, int anneeMin, int anneeMax) {
		return taxeBoissonDao.findByTrimBetweenAndAnneeBetween(trimMin, trimMax, anneeMin, anneeMax);
	}

	

}
