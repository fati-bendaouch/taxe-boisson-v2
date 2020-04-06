package com.example.taxBoisson.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.taxBoisson.bean.Notification;
import com.example.taxBoisson.service.facade.NotificationService;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("/taxe-boisson-api/notification")
public class NotificationRest {
	@Autowired
	private NotificationService notificationService;
	@GetMapping("/")
	public List<Notification> findAll() {
		return notificationService.findAll();
	}
	@GetMapping("/redevable/{identifiant}")
	public List<Notification> findByRedevableIdentifiant(@PathVariable String identifiant) {
		return notificationService.findByRedevableIdentifiant(identifiant);
	}
	@GetMapping("/locale/{reference}")
	public List<Notification> findByLocaleReference(@PathVariable String reference) {
		return notificationService.findByLocaleReference(reference);
	}
	@PostMapping("/")
	public int create(@RequestBody Notification notification) {
		return notificationService.create(notification);
	}
	@DeleteMapping("/")
	public int delete(Notification notification) {
		return notificationService.delete(notification);
	}
	@PutMapping("/")
	public int update(Notification notification) {
		return notificationService.update(notification);
	}
	@PostMapping("/trimMin/{trimMin}/trimMax/{trimMax}/anneeMin/{anneeMin}/anneeMax/{anneeMax}")
	public void notifierTout(@PathVariable int trimMin,@PathVariable int trimMax,@PathVariable int anneeMin,@PathVariable int anneeMax) {
		notificationService.notifierTout(trimMin, trimMax, anneeMin, anneeMax);
	}
	
}
