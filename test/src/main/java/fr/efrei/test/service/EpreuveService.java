package fr.efrei.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import fr.efrei.test.dto.epreuve.CreateEpreuve;
import fr.efrei.test.model.Epreuve;
import fr.efrei.test.model.Evenement;
import fr.efrei.test.repository.EpreuveRepository;
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

}
