package com.example.taxBoisson.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.taxBoisson.bean.Redevable;
import com.example.taxBoisson.service.RedevableService;

@RestController
@RequestMapping("projet/Redevable")
public class RedevableRest{
@Autowired
public RedevableService redevableService;
@GetMapping("/identifiant/{identifiant}")
public Redevable findByidentientant(@PathVariable String identifiant) {
	return redevableService.findByIdentifiant(identifiant);
}
@PostMapping("/")
public int save(@RequestBody Redevable redevable) {
	return redevableService.save(redevable);
}
@GetMapping("/")
public List<Redevable> findAll(){
	return redevableService.findAll();
}
@GetMapping("/libelle/{libelle}")
public List<Redevable> findByTypeRedevable(@ PathVariable String libelle) {
	return redevableService.findByTypeRedevable(libelle);
}
@GetMapping("/nom/{nom}")
public List<Redevable> findByQuartier(@PathVariable String nom) {
	return redevableService.findByQuartier(nom);
}



}
