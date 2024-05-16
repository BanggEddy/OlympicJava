package fr.efrei.test.service;

import fr.efrei.test.dto.CreateEvenement;
import fr.efrei.test.dto.UpdateEvenement;
import fr.efrei.test.model.Evenement;
import fr.efrei.test.repository.EvenementRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EvenementService {

	private final EvenementRepository repository;

	@Autowired
	public EvenementService(EvenementRepository repository) {
		this.repository = repository;
	}

	public List<Evenement> findAllEvenements() {
		return repository.findAllByDeletedAtNull();
	}

	public Evenement findEvenementById(String uuid) {
		return repository.findOneByUuid(uuid).orElse(null);
	}

    public Evenement create(CreateEvenement evenementDto) {
        Evenement evenementACreer = new Evenement(
                evenementDto.getNom(),
                evenementDto.getTypeSport(),
                evenementDto.getLieu(),
                evenementDto.getDateDebut(),
                evenementDto.getDateFin(),
                evenementDto.getDescription()
        );
        return repository.save(evenementACreer);
    }

	@Transactional
	public boolean delete(String uuid) {
		Evenement evenementASupprimer = findEvenementById(uuid);
		if(evenementASupprimer != null && evenementASupprimer.getDeletedAt() == null) {
			evenementASupprimer.setDeletedAt(LocalDateTime.now());
			repository.save(evenementASupprimer);
			return true;
		}
		return false;
	}

	public boolean update(String uuid, UpdateEvenement evenement) {
		Evenement evenementAModifier = findEvenementById(uuid);

		if(evenementAModifier != null) {
            evenementAModifier.setNom(evenement.getNom());
            evenementAModifier.setTypeSport(evenement.getTypeSport());
            evenementAModifier.setLieu(evenement.getLieu());
            evenementAModifier.setDateDebut(evenement.getDateDebut());
            evenementAModifier.setDateFin(evenement.getDateFin());
            evenementAModifier.setDescription(evenement.getDescription());
            repository.save(evenementAModifier);
			return true;
		}
		return false;
	}

	public boolean updatePartielle(String uuid, UpdateEvenement evenement) {
		Evenement evenementAModifier = findEvenementById(uuid);

		if(evenementAModifier != null) {
			if(!evenement.getNom().isEmpty()) {
				evenementAModifier.setNom(evenement.getNom());
			}
			if(!evenement.getTypeSport().isEmpty()) {
				evenementAModifier.setTypeSport(evenement.getTypeSport());
			}
			if(!evenement.getLieu().isEmpty()) {
				evenementAModifier.setLieu(evenement.getLieu());
			}
			if (evenement.getDateDebut() != null) {
				evenementAModifier.setDateDebut(evenement.getDateDebut());
			}
			if (evenement.getDateFin() != null) {
				evenementAModifier.setDateFin(evenement.getDateFin());
			}
			if(!evenement.getDescription().isEmpty()) {
				evenementAModifier.setDescription(evenement.getDescription());
			}
			repository.save(evenementAModifier);
			return true;
		}
		return false;
	}
}
