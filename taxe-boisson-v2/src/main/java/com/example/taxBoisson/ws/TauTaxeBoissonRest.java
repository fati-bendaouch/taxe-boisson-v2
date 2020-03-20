package com.example.taxBoisson.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.taxBoisson.bean.Categorie;
import com.example.taxBoisson.bean.TauxTaxeBoisson;
import com.example.taxBoisson.service.facade.TauxTaxeBoissonService;

@RestController
@RequestMapping("TaxeBoisson/TauxTaxeBoisson")
public class TauTaxeBoissonRest {
	@Autowired
	private TauxTaxeBoissonService TauxTaxeBoissonService;
	@PostMapping("/")
	public void save(@RequestBody Categorie categorie) {
		
		
	}

}
