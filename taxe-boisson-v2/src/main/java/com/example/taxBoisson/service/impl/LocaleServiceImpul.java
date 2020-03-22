package com.example.taxBoisson.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.taxBoisson.bean.Locale;
import com.example.taxBoisson.dao.LocalDao;
import com.example.taxBoisson.service.facade.LocaleService;
import com.example.taxBoisson.service.facade.RedevableService;
import com.example.taxBoisson.bean.Redevable;

@Service
public class LocaleServiceImpul implements LocaleService {
	@Autowired
	private LocalDao localedao;
	@Autowired
	private RedevableService redevableService;

	@Override
	public Locale findByReference(String reference) {

		return localedao.findByReference(reference);
	}

	@Override
	public int save(Locale locale) {
		Locale loca = localedao.findByReference(locale.getReference());
		if (loca != null) {
			return -1;
		} else {

			localedao.save(locale);
			return 1;
		}
	}

	@Override
	public List<Locale> findAll() {

		return localedao.findAll();
	}

	@Override
	public List<Locale> findByRedevabIdentifiant(String identifiant) {
		Redevable redevable = redevableService.findByIdentifiant(identifiant);
		List<Locale> locales = findAll();
		List<Locale> locales2 = new ArrayList<Locale>();
		for (Locale l : locales) {
			if (l.getRedevable() == redevable)
				locales2.add(l);
		}
		return locales2;
	}

	@Override
	public List<Locale> findByRueNomAndCategorieLibelle(String nom, String libelle) {
		return localedao.findByRueNomAndCategorieLibelle(nom, libelle);
	}

	@Override
	public List<Locale> findByRueQuartierNomAndCategorieLibelle(String nom, String libelle) {
		return localedao.findByRueQuartierNomAndCategorieLibelle(nom, libelle);
	}

	@Override
	public List<Locale> findByRueQuartierSecteurNomAndCategorieLibelle(String nom, String libelle) {
		return localedao.findByRueQuartierSecteurNomAndCategorieLibelle(nom, libelle);
	}

	@Override
	public List<Locale> findByDernierTrimPayeBetweenAndDernierAnneePayeBetween(int trimMin, int trimMax, int anneeMin,
			int anneeMax) {
		return localedao.findByDernierTrimPayeBetweenAndDernierAnneePayeBetween(trimMin, trimMax, anneeMin, anneeMax);
	}

	@Transactional
	public int deleteByReference(String reference) {
		if (findByReference(reference) == null)
			return -1;
		else {
			localedao.deleteByReference(reference);
			return 1;
		}
	}
}
