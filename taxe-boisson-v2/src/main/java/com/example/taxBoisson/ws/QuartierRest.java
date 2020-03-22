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

import com.example.taxBoisson.bean.Quartier;
import com.example.taxBoisson.service.facade.QuartierService;

@RestController
@RequestMapping("projet/quartier")
public class QuartierRest {
@Autowired
	private QuartierService  quartierService;

/**
 * @return
 * @see com.example.taxBoisson.service.facade.QuartierService#findAll()
 */
@GetMapping("/")
public List<Quartier> findAll() {
	return quartierService.findAll();
}

/**
 * @param nom
 * @return
 * @see com.example.taxBoisson.service.facade.QuartierService#findByNom(java.lang.String)
 */
@GetMapping("nom/{nom}")
public Quartier findByNom(@PathVariable String nom) {
	return quartierService.findByNom(nom);
}

/**
 * @param quartier
 * @see com.example.taxBoisson.service.facade.QuartierService#save(com.example.taxBoisson.bean.Quartier)
 */
@PostMapping("/")
public int save(@RequestBody Quartier quartier) {
return 	quartierService.save(quartier);}



@GetMapping("/nom1/{nom}")
public List<Quartier> findBySecteurNom( @PathVariable String nom) {
	return quartierService.findBySecteurNom(nom);
}
@DeleteMapping("/nom/{nom}")
public int deleteByNom(@PathVariable String nom) {
	return quartierService.deleteByNom(nom);
}


}
