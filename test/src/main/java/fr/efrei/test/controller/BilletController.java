package fr.efrei.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.efrei.test.dto.billet.CreateBillet;
import fr.efrei.test.dto.billet.UpdateBillet;
import fr.efrei.test.model.Billet;
import fr.efrei.test.service.BilletService;

@RestController
@RequestMapping("/billet")
public class BilletController {
    private final BilletService service;

    @Autowired
    public BilletController(BilletService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Billet>> findAll() {
        return new ResponseEntity<>(service.findAllBillet(), HttpStatus.OK);
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<Billet> findOneById(@PathVariable String uuid) {
        Billet billet = service.findBilletById(uuid);
        if (billet != null) {
            return new ResponseEntity<>(service.findBilletById(uuid), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Billet> save(@RequestBody CreateBillet billet) {
        Billet createdBillet = service.create(billet);
        return new ResponseEntity<>(createdBillet, HttpStatus.CREATED);
    }

    @DeleteMapping("/{uuid}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> delete(@PathVariable String uuid) {
        boolean isDeleted = service.delete(uuid);
        if (isDeleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{uuid}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> mettreAJourTotalement(
            @PathVariable String uuid,
            @RequestBody UpdateBillet billet) {
        boolean isUpdated = service.update(uuid, billet);
        if (isUpdated) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PatchMapping("/{uuid}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> mettreAjourPartiellement(
            @PathVariable String uuid,
            @RequestBody UpdateBillet billet) {
        boolean isUpdated = service.updatePartielle(uuid, billet);
        if (isUpdated) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
