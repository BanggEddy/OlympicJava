package fr.efrei.test.service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import fr.efrei.test.dto.UpdateEvenement;
import fr.efrei.test.dto.epreuve.CreateEpreuve;
import fr.efrei.test.dto.epreuve.UpdateEpreuve;
import fr.efrei.test.model.Epreuve;
import fr.efrei.test.model.Evenement;
import fr.efrei.test.repository.EpreuveRepository;
import jakarta.transaction.Transactional;

import org.springframework.stereotype.Service;

@Service
public class EpreuveService {

    private final EpreuveRepository repository;

    @Autowired
    public EpreuveService(EpreuveRepository repository) {
        this.repository = repository;
    }

	public List<Epreuve> findAllEpreuve() {
		return repository.findAllByDeletedAtNull();
	}

	public Epreuve findEpreuveById(String uuid) {
		return repository.findOneByUuid(uuid).orElse(null);
	}

    public Epreuve create(CreateEpreuve epreuveDto) {
        Epreuve epreuveACreer = new Epreuve(
                epreuveDto.getNom(),
                epreuveDto.getDate(),
                epreuveDto.getStade(),
                epreuveDto.getHorraire(),
                epreuveDto.getUpdateAt(),
                epreuveDto.getCreateAt(),
                epreuveDto.getEvenement()
        );
        return repository.save(epreuveACreer);
    }
	@Transactional
	public boolean delete(String uuid) {
		Epreuve epreuveASupprimer = findEpreuveById(uuid);
		if(epreuveASupprimer != null && epreuveASupprimer.getDeletedAt() == null) {
			epreuveASupprimer.setDeletedAt(LocalDateTime.now());
			repository.save(epreuveASupprimer);
			return true;
		}
		return false;
	}

    public boolean update(String uuid, UpdateEpreuve epreuve) {
	Epreuve epreuveAModifier = findEpreuveById(uuid);

	if(epreuveAModifier != null) {
        epreuveAModifier.setNom(epreuve.getNom());
        epreuveAModifier.setDate(epreuve.getDate());
        epreuveAModifier.setStade(epreuve.getStade());
        epreuveAModifier.setHorraire(epreuve.getHorraire());
        epreuveAModifier.setUpdatedAt(epreuve.getUpdateAt());
        epreuveAModifier.setCreatedAt(epreuve.getCreateAt());
        epreuveAModifier.setEvenement(epreuve.getEvenement());
        repository.save(epreuveAModifier);
		return true;
	}
	return false;
	}

    public boolean updatePartielle(String uuid, UpdateEpreuve epreuve) {
        Epreuve epreuveAModifier = findEpreuveById(uuid);
    
        if(epreuveAModifier != null) {
            if(!epreuve.getNom().isEmpty()) {
                epreuveAModifier.setNom(epreuve.getNom());
            }
            if(epreuve.getDate() != null) {
                epreuveAModifier.setDate(epreuve.getDate());
            }
            if(!epreuve.getStade().isEmpty()) {
                epreuveAModifier.setStade(epreuve.getStade());
            }
            if(!epreuve.getHorraire().isEmpty()) {
                epreuveAModifier.setHorraire(epreuve.getHorraire());
            }
            if (epreuve.getUpdateAt() != null) {
                epreuveAModifier.setUpdatedAt(epreuve.getUpdateAt());
            }
            if (epreuve.getCreateAt() != null) {
                epreuveAModifier.setCreatedAt(epreuve.getCreateAt());
            }
            if(epreuve.getEvenement() != null) {
                epreuveAModifier.setEvenement(epreuve.getEvenement());
            }
            repository.save(epreuveAModifier);
            return true;
        }
        return false;
    }
    
    
}
