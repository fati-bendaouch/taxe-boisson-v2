package com.example.taxBoisson.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.taxBoisson.bean.TypeRedevable;
import com.example.taxBoisson.service.facade.TypeRedevableService;

@RestController
@RequestMapping("projet/TypeRedevable")
public class TypeRedevableRest {
	@Autowired
	public TypeRedevableService typeRedevableService;
	@GetMapping("/libelle/{libelle}")
	public TypeRedevable findByLibelle(@PathVariable String libelle) {
		return typeRedevableService.findByLibelle(libelle);
	}
	@PostMapping("/")
	public int save( @RequestBody TypeRedevable typeRedevable) {
		return typeRedevableService.save(typeRedevable);
	}
	@GetMapping("/")
	public List<TypeRedevable> findAll(){
		return typeRedevableService.findAll();
		}
	

}
