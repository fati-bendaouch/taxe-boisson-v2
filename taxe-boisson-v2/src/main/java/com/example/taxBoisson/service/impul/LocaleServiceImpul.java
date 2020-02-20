package com.example.taxBoisson.service.impul;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.taxBoisson.bean.Locale;
import com.example.taxBoisson.dao.LocalDao;
import com.example.taxBoisson.service.LocaleService;

@Service
public class LocaleServiceImpul implements LocaleService {
	@Autowired
  private LocalDao localedao;

	@Override
	public Locale findByReference(String reference) {
		
		return localedao.findByReference(reference) ;
	}

	@Override
	public void save(Locale locale) {
		localedao.save(locale);
		
	}

	@Override
	public List<Locale> findAll() {
		
		return localedao.findAll();
	}

}
