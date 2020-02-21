package com.example.taxBoisson.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
public class RedevableRest {
@Autowired
public RedevableService redevableService;
@GetMapping("/identientant/{identientant}")
public Redevable findByidentientant(@PathVariable String identientant) {
	return redevableService.findByIdentientant(identientant);
}
@PostMapping("/")
public void save(@RequestBody Redevable redevable) {
	redevableService.save(redevable);
}
@GetMapping("/")
public List<Redevable> findAll(){
	return redevableService.findAll();
}



}
