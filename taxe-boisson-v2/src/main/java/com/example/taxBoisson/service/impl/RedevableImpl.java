package com.example.taxBoisson.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.taxBoisson.bean.Locale;
import com.example.taxBoisson.bean.Quartier;
import com.example.taxBoisson.bean.Redevable;
import com.example.taxBoisson.dao.RedevableDao;
import com.example.taxBoisson.service.facade.LocaleService;
import com.example.taxBoisson.service.facade.QuartierService;
import com.example.taxBoisson.service.facade.RedevableService;
import com.example.taxBoisson.service.facade.RueService;
import com.example.taxBoisson.service.facade.TypeRedevableService;
import com.example.taxBoisson.bean.Rue;

@Service
public class RedevableImpl implements RedevableService {
	@Autowired

	private RedevableDao redevableDao;
	@Autowired
	private TypeRedevableService typeRedevableService;
	@Autowired
	private QuartierService quartierService;
	@Autowired 
	private RueService rueService;
	@Autowired
	private LocaleService localeService;
	
	@Override
	public Redevable findByIdentifiant(String identifiant) {
		// TODO Auto-generated method stub
		return redevableDao.findByIdentifiant(identifiant);
	}

	@Override
	public List<Redevable> findAll() {
		// TODO Auto-generated method stub
		return redevableDao.findAll();
	}

	@Override
	public int save(Redevable redevable) {
		if(findByIdentifiant(redevable.getIdentifiant())!=null)
			return -1;
		else {
			redevableDao.save(redevable);
			return 1;
			} 
			
		
	}


	@Override
	public List<Redevable> findByTypeRedevable(String libelle) {
		List<Redevable> redevables=	redevableDao.findAll();	
		List<Redevable> redevables1=new ArrayList<Redevable>();
		for(Redevable re:redevables) {
			if(typeRedevableService.findByLibelle(libelle)==re.getTypeRedevable()) {
				redevables1.add(re);
			}
		}
		return redevables1;

	}

	@Override
	public List<Redevable> findByQuartier(String nom) {
      Quartier quartier=quartierService.findByNom(nom);
      List<Redevable> redevables=new ArrayList<Redevable>();
      for(Rue r:rueService.findByQuartierNom(quartier.getNom())) {
    	  List<Locale> locales = localeService.findByRueNom(r.getNom());
    	  for(Locale l:locales) {
    		 redevables.add(l.getRedevable()) ;
    	  }
      }
      
		return redevables;
	}
	@Override
	@Transactional
	public int deleteByIdentifiant(String identifiant) {
	if(findByIdentifiant(identifiant)==null)
		return -1;
	else {
		redevableDao.deleteByIdentifiant(identifiant);
		return 1;
	}
		
	}
	

}
