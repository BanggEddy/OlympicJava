package fr.efrei.test.controller;

import fr.efrei.test.dto.CreateEvenement;
import fr.efrei.test.dto.UpdateEvenement;
import fr.efrei.test.model.Evenement;
import fr.efrei.test.service.EvenementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/evenement")
public class EvenementController {

	private final EvenementService service;

	@Autowired
	public EvenementController(EvenementService service) {
		this.service = service;
	}

	@GetMapping
	public ResponseEntity<List<Evenement>> findAll() {
		return new ResponseEntity<>(service.findAllEvenements(), HttpStatus.OK);
	}

	@GetMapping("/{uuid}")
	public ResponseEntity<Evenement> findOneById(@PathVariable String uuid) {
		Evenement evenement = service.findEvenementById(uuid);
		if(evenement != null) {
			return new ResponseEntity<>(service.findEvenementById(uuid), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PostMapping
	@PreAuthorize("hasAuthority('ADMIN')")
	public ResponseEntity<Evenement> save(@RequestBody CreateEvenement evenement) {
		Evenement createdEvenement = service.create(evenement);
		return new ResponseEntity<>(createdEvenement, HttpStatus.CREATED);
	}

	@DeleteMapping("/{uuid}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public ResponseEntity<?> delete(@PathVariable String uuid) {
		boolean isDeleted = service.delete(uuid);
		if(isDeleted) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PutMapping("/{uuid}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public ResponseEntity<?> mettreAJourTotalement(
			@PathVariable String uuid,
			@RequestBody UpdateEvenement evenement) {
		boolean isUpdated = service.update(uuid, evenement);
		if(isUpdated) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PatchMapping("/{uuid}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public ResponseEntity<?> mettreAjourPartiellement(
			@PathVariable String uuid,
			@RequestBody UpdateEvenement evenement) {
		boolean isUpdated = service.updatePartielle(uuid, evenement);
		if(isUpdated) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
