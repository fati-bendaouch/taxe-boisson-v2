package com.example.taxBoisson.service;

import java.util.List;

import com.example.taxBoisson.bean.Locale;

public interface LocaleService {
	public  Locale findByReference(String reference);
	public int  save(Locale locale);
	public List<Locale>findAll();
	

}
