package fr.efrei.test.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import fr.efrei.test.dto.epreuve.CreateEpreuve;
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
}
