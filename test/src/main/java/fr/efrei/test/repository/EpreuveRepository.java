package fr.efrei.test.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.efrei.test.model.Epreuve;

@Repository
public interface EpreuveRepository extends JpaRepository<Epreuve, String> {
    
    List<Epreuve> findAllByDeletedAtNull();

	Optional<Epreuve> findOneByUuid(String uuid);

	Epreuve save(Epreuve epreuve);

	void deleteByUuid(String uuid);
}
