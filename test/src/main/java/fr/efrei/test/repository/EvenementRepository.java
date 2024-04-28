package fr.efrei.test.repository;

import fr.efrei.test.model.Evenement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EvenementRepository extends JpaRepository<Evenement, Long> {
    	// SELECT * from Student where deleted_at is null
	List<Evenement> findAllByDeletedAtNull();

}
