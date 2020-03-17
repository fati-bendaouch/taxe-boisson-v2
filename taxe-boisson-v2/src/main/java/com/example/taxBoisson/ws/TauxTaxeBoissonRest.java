package com.example.taxBoisson.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.taxBoisson.bean.TauxTaxeBoisson;
import com.example.taxBoisson.service.TauxtaxeBoissonService;

@RestController
@RequestMapping("projet/tauxTaxeBoissonRest")
public class TauxTaxeBoissonRest {
@Autowired
	private TauxtaxeBoissonService tauxtaxeBoissonService;

/**
 * @param libelle
 * @param tauxnormel
 * @param tauxretard
 * @return
 * @see com.example.taxBoisson.service.TauxtaxeBoissonService#modify(java.lang.String, int, int)
 */
@PutMapping("/libelle/{libelle}/tauxnormel/{tauxnormel}/tauxretard/{tauxretard}")
public int modify(@PathVariable String libelle,@PathVariable int tauxnormel,@PathVariable int tauxretard) {
	return tauxtaxeBoissonService.modify(libelle, tauxnormel, tauxretard);
}

/**
 * @param local
 * @return
 * @see com.example.taxBoisson.service.TauxtaxeBoissonService#tauxlocal(java.lang.String)
 */
@GetMapping("/local/{local}")
public TauxTaxeBoisson tauxlocal( @PathVariable String local) {
	return tauxtaxeBoissonService.tauxlocal(local);
}

/**
 * @param c
 * @return
 * @see com.example.taxBoisson.service.TauxtaxeBoissonService#deleteByCategorie(com.example.taxBoisson.bean.Categorie)
 */
@DeleteMapping("libelle/{libelle}")
public int deleteByCategorieLibelle(  @PathVariable String libelle) {
	return tauxtaxeBoissonService.deleteByCategorieLibelle(libelle);
}

/**
 * @return
 * @see com.example.taxBoisson.service.TauxtaxeBoissonService#findAll()
 */
@GetMapping("/")
public List<TauxTaxeBoisson> findAll() {
	return tauxtaxeBoissonService.findAll();
}

/**
 * @param libelle
 * @return
 * @see com.example.taxBoisson.service.TauxtaxeBoissonService#findByCategorieLibelle(java.lang.String)
 */
@GetMapping("/libelle/{libelle}/")
public TauxTaxeBoisson findByCategorieLibelle(@PathVariable String libelle) {
	return tauxtaxeBoissonService.findByCategorieLibelle(libelle);
}

/**
 * @param t
 * @return
 * @see com.example.taxBoisson.service.TauxtaxeBoissonService#save(com.example.taxBoisson.bean.TauxTaxeBoisson)
 */
@PostMapping("/")
public int save(@RequestBody TauxTaxeBoisson taxe) {
	return tauxtaxeBoissonService.save(taxe);
}

/**
 * @param libelle
 * @return
 * @see com.example.taxBoisson.service.TauxtaxeBoissonService#findByCategorieLibelle(java.lang.String)
 */

}
