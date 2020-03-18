package com.example.taxBoisson.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.taxBoisson.bean.Locale;
import com.example.taxBoisson.service.facade.LocaleService;

@RestController
@RequestMapping("TaxeBoxe/Local")
public class LocalRest {
	@Autowired
	private LocaleService localService ;

	@GetMapping("/reference/{reference}")
	public Locale findByReference(@PathVariable  String reference) {
		
		return localService.findByReference(reference) ;
	}

	@PostMapping("/")
	public int save(@RequestBody Locale locale) {
		return 	localService.save(locale);
		
		}

	
@GetMapping("/")
	public List<Locale> findAll() {
		
		return localService.findAll();
	}
@GetMapping("/identifiant/{identifiant}")
public List<Locale> findByRedevabIdentifiant( @PathVariable String identifiant) {
	return localService.findByRedevabIdentifiant(identifiant);
}
	
	
	

}
