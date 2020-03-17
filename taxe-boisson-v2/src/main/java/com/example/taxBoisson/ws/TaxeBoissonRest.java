package com.example.taxBoisson.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.taxBoisson.bean.TaxeBoisson;
import com.example.taxBoisson.service.facade.LocaleService;
import com.example.taxBoisson.service.facade.RedevableService;
import com.example.taxBoisson.service.facade.TaxeBoissonService;

@RequestMapping("TaxeBoisson/TaxeBoisson")
@RestController
public class TaxeBoissonRest {
	@Autowired
	private TaxeBoissonService taxeBoissonService;
	@Autowired
	private LocaleService localeService;
	@Autowired
	private RedevableService redevableService;

	@PostMapping("/")
	public int save(@RequestBody TaxeBoisson taxeBoisson) {
		return taxeBoissonService.save(taxeBoisson);
	}

	@PostMapping("/Simulation/")
	public int Simulation(@RequestBody TaxeBoisson taxeBoisson) {
		return taxeBoissonService.simulation(taxeBoisson);
	}

}
