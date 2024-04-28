package fr.efrei.test.service;
import java.util.List;
import fr.efrei.test.repository.EvenementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import fr.efrei.test.model.Evenement;
import org.springframework.stereotype.Service;

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

}
