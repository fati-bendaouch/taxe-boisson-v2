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

import com.example.taxBoisson.bean.Locale;
import com.example.taxBoisson.service.facade.LocaleService;

@RestController
@RequestMapping("TaxeBoxe/Local")
public class LocalRest {
	@Autowired
	private LocaleService localService;
//	public List<Locale> findByRueNom(String nom) {
//		return localService.findByRueNom(nom);
//	}
	@GetMapping("/notification/locale")
	public List<Locale> findByDernierTrimPayerAndDernierAnneePayer() {
		return localService.findByDernierTrimPayerAndDernierAnneePayer();
	}

	@GetMapping("/dernierTrimPaye/{dernierTrimPaye}")
	public List<Locale> findByDernierTrimPaye(int dernierTrimPaye) {
		return localService.findByDernierTrimPaye(dernierTrimPaye);
	}

	@GetMapping("/trimMin/{trimMin}/trimMax/{trimMax}/anneeMin/{anneeMin}/anneeMax/{anneeMax}")
	public List<Locale> findByDernierTrimPayeBetweenAndDernierAnneePayeBetween(@PathVariable int trimMin,
			@PathVariable int trimMax, @PathVariable int anneeMin, @PathVariable int anneeMax) {
		return localService.findByDernierTrimPayeBetweenAndDernierAnneePayeBetween(trimMin, trimMax, anneeMin,
				anneeMax);
	}

	@GetMapping("/rue/nom/{nom}/categorie/{libelle}")
	public List<Locale> findByRueNomAndCategorieLibelle(@PathVariable String nom, @PathVariable String libelle) {
		return localService.findByRueNomAndCategorieLibelle(nom, libelle);
	}

	@GetMapping("/rue/quartier/{nom}/categorie/{libelle}")
	public List<Locale> findByRueQuartierNomAndCategorieLibelle(@PathVariable String nom,
			@PathVariable String libelle) {
		return localService.findByRueQuartierNomAndCategorieLibelle(nom, libelle);
	}

	@GetMapping("/rue/quartier/secteur/{nom}/categorie/{libelle}")
	public List<Locale> findByRueQuartierSecteurNomAndCategorieLibelle(@PathVariable String nom,
			@PathVariable String libelle) {
		return localService.findByRueQuartierSecteurNomAndCategorieLibelle(nom, libelle);
	}

	@GetMapping("/reference/{reference}")
	public Locale findByReference(@PathVariable String reference) {

		return localService.findByReference(reference);
	}

	@PostMapping("/")
	public int save(@RequestBody Locale locale) {
		return localService.save(locale);

	}

	@GetMapping("/")
	public List<Locale> findAll() {

		return localService.findAll();
	}

	@GetMapping("/identifiant/{identifiant}")
	public List<Locale> findByRedevabIdentifiant(@PathVariable String identifiant) {
		return localService.findByRedevabIdentifiant(identifiant);
	}

	@DeleteMapping("/reference/{reference}")
	public int deleteByReference(@PathVariable String reference) {
		return localService.deleteByReference(reference);
	}

}
