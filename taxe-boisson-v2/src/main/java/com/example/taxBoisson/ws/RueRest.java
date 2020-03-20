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

import com.example.taxBoisson.bean.Rue;
import com.example.taxBoisson.service.facade.RueService;

@RestController
@RequestMapping("projet/rue")
public class RueRest {
	@Autowired
	private RueService rueservie;

	/**
	 * @param rue
<<<<<<< HEAD
	 * @see com.example.taxBoisson.service.facade.RueService#save(com.example.taxBoisson.bean.Rue)
=======
	 * @param redevable
	 * @return
	 * @see com.example.taxBoisson.service.RueService#find(java.lang.String, java.lang.String)
	 */
	@GetMapping("/rue/{rue}/redevable/{redevable}")
	public int find(@PathVariable String rue,@PathVariable String redevable) {
		return rueservie.find(rue, redevable);
	}

	
	/**
	 * @param nom
	 * @return
	 * @see com.example.taxBoisson.service.RueService#deleteByNom(java.lang.String)
	 */
	@DeleteMapping("/nom/{nom}")
	public int deleteByNom(@PathVariable String nom) {
		return rueservie.deleteByNom(nom);
	}

	/**
	 * @return
	 * @see com.example.taxBoisson.service.RueService#findAll()
	 */
	@GetMapping("/")
	public List<Rue> findAll() {
		return rueservie.findAll();
	}

	/**
	 * @param rue
	 * @see com.example.taxBoisson.service.RueService#save(com.example.taxBoisson.bean.Rue)
>>>>>>> branch 'master' of https://github.com/fati-bendaouch/taxe-boisson-v2.git
	 */
	@PostMapping("/")
	public int save(@RequestBody Rue rue) {
	return	rueservie.save(rue);
	}

	/**
	 * @param nom
	 * @return
	 * @see com.example.taxBoisson.service.facade.RueService#findByNom(java.lang.String)
	 */
	@GetMapping("nom/{nom}")
	public Rue findByNom (@PathVariable String nom) {
		return rueservie.findByNom(nom);
	}

}
