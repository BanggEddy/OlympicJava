package fr.efrei.test.service;

import fr.efrei.test.dto.CreateEvenement;
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

	public Evenement findStudentById(String uuid) {
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
		Evenement evenementASupprimer = findStudentById(uuid);
		if(evenementASupprimer != null && evenementASupprimer.getDeletedAt() == null) {
			evenementASupprimer.setDeletedAt(LocalDateTime.now());
			repository.save(evenementASupprimer);
			return true;
		}
		return false;
	}
}
