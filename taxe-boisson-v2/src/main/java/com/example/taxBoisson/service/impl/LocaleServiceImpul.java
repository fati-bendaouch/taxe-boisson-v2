package com.example.taxBoisson.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.taxBoisson.bean.Locale;
import com.example.taxBoisson.bean.Redevable;
import com.example.taxBoisson.dao.LocalDao;
import com.example.taxBoisson.service.LocaleService;
import com.example.taxBoisson.service.RedevableService;

@Service
public class LocaleServiceImpul implements LocaleService {
	@Autowired
  private LocalDao localedao;
	@Autowired
	private RedevableService redevableService;

	@Override
	public Locale findByReference(String reference) {
		
		return localedao.findByReference(reference) ;
	}

	@Override
	public int  save(Locale locale) {
		Locale loca=localedao.findByReference(locale.getReference());
		if(loca!=null) {
			return -1;
		}else {
		
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
		Redevable redevable= redevableService.findByIdentifiant(identifiant);
		List<Locale>locales=findAll();
		List<Locale>locales2=new ArrayList<Locale>();
		for(Locale l:locales) {
			if(l.getRedevable()==redevable)
				locales2.add(l);
		}
		return locales2;
	}


	

}
