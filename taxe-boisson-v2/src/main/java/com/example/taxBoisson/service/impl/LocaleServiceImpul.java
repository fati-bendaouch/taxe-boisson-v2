package com.example.taxBoisson.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.taxBoisson.bean.Locale;
import com.example.taxBoisson.dao.LocalDao;
import com.example.taxBoisson.service.facade.LocaleService;
import com.example.taxBoisson.service.facade.RedevableService;

@Service
public class LocaleServiceImpul implements LocaleService {
	@Autowired
  private LocalDao localedao;

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

	
	
	}

