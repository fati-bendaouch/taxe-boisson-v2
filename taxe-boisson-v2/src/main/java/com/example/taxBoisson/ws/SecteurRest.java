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

import com.example.taxBoisson.bean.Secteur;
import com.example.taxBoisson.service.SecteurService;

@RestController
@RequestMapping("projet/secteur")
public class SecteurRest {
	@Autowired
	private SecteurService secteurService;
	

	/**
	 * @param nom
	 * @return
	 * @see com.example.taxBoisson.service.SecteurService#deleteByNom(java.lang.String)
	 */
	@DeleteMapping("/nom/{nom}")
	public int deleteByNom(@PathVariable String nom) {
		return secteurService.deleteByNom(nom);
	}

	/**
	 * @return
	 * @see com.example.taxBoisson.service.SecteurService#findAll()
	 */
	@GetMapping("/")
	public List<Secteur> findAll() {
		return secteurService.findAll();
	}

	/**
	 * @param nom
	 * @return
	 * @see com.example.taxBoisson.service.SecteurService#findByNom(java.lang.String)
	 */
	@GetMapping("/nom/{nom}")
	public Secteur findByNom(@PathVariable String nom) {
		return secteurService.findByNom(nom);
	}

	/**
	 * @param secteur
	 * @see com.example.taxBoisson.service.SecteurService#save(com.example.taxBoisson.bean.Secteur)
	 */
	@PostMapping("/")
	public int  save(@RequestBody Secteur secteur) {
	return 	secteurService.save(secteur);
	}
}
