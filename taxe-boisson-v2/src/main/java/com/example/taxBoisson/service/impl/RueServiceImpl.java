package com.example.taxBoisson.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.taxBoisson.bean.Locale;
import com.example.taxBoisson.bean.Redevable;
import com.example.taxBoisson.bean.Rue;
import com.example.taxBoisson.dao.RueDao;
import com.example.taxBoisson.service.facade.LocaleService;
import com.example.taxBoisson.service.facade.RedevableService;
import com.example.taxBoisson.service.facade.RueService;

@Service
public class RueServiceImpl implements RueService {
	@Autowired
	private RueDao ruedao;
	@Autowired
	private RedevableService redevableservice;
	@Autowired
	private LocaleService localeService;
	@Override
	public int save(Rue rue) {
		// TODO Auto-generated method stub
		if (findByNom(rue.getNom()) != null)
			return -1;
		else {
			ruedao.save(rue);
			return 1;
		}
	}

	@Override
	public Rue findByNom(String nom) {
		// TODO Auto-generated method stub
		return ruedao.findByNom(nom);
	}

	@Override
	public List<Rue> findAll() {
		// TODO Auto-generated method stub
		return ruedao.findAll();
	}

	@Override
	@Transactional
	public int deleteByNom(String nom) {
		// TODO Auto-generated method stub
		if (findByNom(nom) == null)
			return -1;
		else {
			ruedao.deleteByNom(nom);
			return 1;
		}
	}

	@Override
	public int find(String rue, String redevable) {
		Rue R=findByNom(rue);
		Redevable redeva=redevableservice.findByIdentifiant(redevable);
		if(R==null||redeva==null)return -1;
		else {
		List<Locale> locales=localeService.findByRueNom(rue);
		int i=0;
		for(Locale locale:locales) {
			if(locale.getRedevable()==redeva)
				i++;
		}
		return i;		
	}
	}

	@Override
	public List<Rue> findByQuartierNom(String nom) {
		return ruedao.findByQuartierNom(nom);
	}

}
