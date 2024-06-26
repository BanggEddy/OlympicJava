package fr.efrei.test.repository;

import fr.efrei.test.model.Evenement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EvenementRepository extends JpaRepository<Evenement, String> {

	List<Evenement> findAllByDeletedAtNull();

	Optional<Evenement> findOneByUuid(String uuid);

	Evenement save(Evenement evenement);

	void deleteByUuid(String uuid);
}
