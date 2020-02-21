package com.example.taxBoisson.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.taxBoisson.bean.Rue;
import com.example.taxBoisson.service.RueService;

@RestController
@RequestMapping("projet/rue")
public class RueRest {
	@Autowired
	private RueService rueservie;

	/**
	 * @param rue
	 * @see com.example.taxBoisson.service.RueService#save(com.example.taxBoisson.bean.Rue)
	 */
	@PostMapping("/")
	public int save(@RequestBody Rue rue) {
	return	rueservie.save(rue);
	}

	/**
	 * @param nom
	 * @return
	 * @see com.example.taxBoisson.service.RueService#findByNom(java.lang.String)
	 */
	@GetMapping("nom/{nom}")
	public Rue findByNom (@PathVariable String nom) {
		return rueservie.findByNom(nom);
	}

}
