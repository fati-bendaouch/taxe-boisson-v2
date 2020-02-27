package com.example.taxBoisson.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.taxBoisson.bean.Categorie;
import com.example.taxBoisson.service.CategorieService;

@RestController
@RequestMapping("TaxeBoisson/Categorie")
public class CategorieRest {
	@Autowired
	private CategorieService  categorieService;
@GetMapping("/libelle/{libelle}")
	public Categorie findByLibelle(@PathVariable String libelle) {
		return categorieService.findByLibelle(libelle);
	}
@PostMapping("/")
	public int  save(@RequestBody Categorie categorie) {
	if(categorieService.findByLibelle(categorie.getLibelle())!=null){
		return -1;
	}else {
		categorieService.save(categorie);
	 return 1;
	}
	}
@GetMapping("/")
	public List<Categorie> findAll() {
		return categorieService.findAll();
	}
	

}
