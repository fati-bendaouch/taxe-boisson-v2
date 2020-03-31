package com.example.taxBoisson.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	@GetMapping("/locale/{reference}")
	public List<TaxeBoisson> findByLocaleReference(@PathVariable String reference) {
		return taxeBoissonService.findByLocaleReference(reference);
	}

//	@PostMapping("/")
//	public int save(@RequestBody TaxeBoisson taxeBoisson) {
//		return  taxeBoissonService.save(taxeBoisson);
//	}
//	
//	@PostMapping("/Simulation/")
//	public TaxeBoisson  simulation(@RequestBody TaxeBoisson taxeBoisson) {
//		return taxeBoissonService.simulation(taxeBoisson);
//		
//	}
	
}
