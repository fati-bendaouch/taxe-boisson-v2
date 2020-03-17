package com.example.taxBoisson.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.taxBoisson.bean.Categorie;
import com.example.taxBoisson.bean.Locale;
import com.example.taxBoisson.bean.TauxTaxeBoisson;
import com.example.taxBoisson.dao.TauxTaxeBoissonDao;
import com.example.taxBoisson.service.CategorieService;
import com.example.taxBoisson.service.LocaleService;
import com.example.taxBoisson.service.TauxtaxeBoissonService;

@Service
public class TauxTaxeBoissonServiceImpl implements TauxtaxeBoissonService {
	@Autowired
	private TauxTaxeBoissonDao tauxTaxeBoissonDao;
	@Autowired
	private CategorieService categorieService;
	@Autowired
	private LocaleService localeservice;

	/**
	 * @return the categorieService
	 */
	public CategorieService getCategorieService() {
		return categorieService;
	}

	/**
	 * @param categorieService the categorieService to set
	 */
	public void setCategorieService(CategorieService categorieService) {
		this.categorieService = categorieService;
	}

	@Override
	public int save(TauxTaxeBoisson taxe) {
		 Categorie c=categorieService.findByLibelle(taxe.getCategorie().getLibelle());
		if (c==null)
			return -1;

		else {
taxe.setCategorie(c);

			tauxTaxeBoissonDao.save(taxe);
			return 1;
		}
	}

	@Override
	public TauxTaxeBoisson findByCategorieLibelle(String libelle) {
		// TODO Auto-generated method stub
		return tauxTaxeBoissonDao.findByCategorieLibelle(libelle);
	}

	@Override
	public List<TauxTaxeBoisson> findAll() {
		// TODO Auto-generated method stub
		return tauxTaxeBoissonDao.findAll();
	}
@Transactional
	@Override
	public int deleteByCategorieLibelle(String libelle) {
		// TODO Auto-generated method stub
	if(	categorieService.findByLibelle(libelle)==null)
		return -1;
	
	else {
		tauxTaxeBoissonDao.deleteByCategorieLibelle(libelle);
		return 1;
	}}

@Override
public TauxTaxeBoisson tauxlocal(String local) {
	// TODO Auto-generated method stub
Locale locale=localeservice.findByReference(local);
TauxTaxeBoisson c=  findByCategorieLibelle(locale.getCategorie().getLibelle());
return c;	
}
@Override
public int modify(String libelle, int tauxnormel, int tauxretard) {
	String c=categorieService.findByLibelle(libelle).getLibelle();
	Categorie categorie=categorieService.findByLibelle(libelle);
	TauxTaxeBoisson taux= findByCategorieLibelle(c);
	if (taux==null)
	return -1;
	else {
		taux.setPourcentageBase(tauxnormel);
		taux.setPourcentageRetard(tauxretard);
		taux.setCategorie(categorie);
		save(taux);
		return 1;
	}
}
}
