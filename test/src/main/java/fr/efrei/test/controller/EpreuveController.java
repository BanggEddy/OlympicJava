package fr.efrei.test.controller;
import org.springframework.web.bind.annotation.RestController;

import fr.efrei.test.dto.epreuve.CreateEpreuve;
import fr.efrei.test.model.Epreuve;
import fr.efrei.test.service.EpreuveService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;



@RestController
@RequestMapping("/epreuve")
public class EpreuveController  {

	private final EpreuveService service;

	@Autowired
	public EpreuveController(EpreuveService service) {
		this.service = service;
	}

    	@GetMapping
	public ResponseEntity<List<Epreuve>> findAll() {
		return new ResponseEntity<>(service.findAllEpreuve(), HttpStatus.OK);
	}

	@GetMapping("/{uuid}")
	public ResponseEntity<Epreuve> findOneById(@PathVariable String uuid) {
		Epreuve epreuve = service.findEpreuveById(uuid);
		if(epreuve != null) {
			return new ResponseEntity<>(service.findEpreuveById(uuid), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

    @PostMapping
	@PreAuthorize("hasAuthority('ADMIN')")
	public ResponseEntity<Epreuve> save(@RequestBody CreateEpreuve epreuve) {
		Epreuve createdEpreuve = service.create(epreuve);
		return new ResponseEntity<>(createdEpreuve, HttpStatus.CREATED);
	}
}