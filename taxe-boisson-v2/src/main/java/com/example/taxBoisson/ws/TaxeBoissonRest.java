package com.example.taxBoisson.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.taxBoisson.bean.TaxeBoisson;
import com.example.taxBoisson.service.facade.TaxeBoissonService;

@RestController
@RequestMapping("TaxeBoisson/taxeBoisson")
public class TaxeBoissonRest {
	@Autowired
	private TaxeBoissonService taxeBoissonService;
	@PostMapping("/")
	public int save(@RequestBody TaxeBoisson taxeBoisson) {
		return  taxeBoissonService.save(taxeBoisson);
	}
	
	@PostMapping("/Simulation/")
	public TaxeBoisson  simulation(@RequestBody TaxeBoisson taxeBoisson) {
		return taxeBoissonService.simulation(taxeBoisson);
		
	}
	
}
