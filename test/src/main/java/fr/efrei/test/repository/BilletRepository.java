package fr.efrei.test.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.efrei.test.model.Billet;

@Repository
public interface BilletRepository extends JpaRepository<Billet, String> {

    List<Billet> findAllByDeletedAtNull();

    Optional<Billet> findOneByUuid(String uuid);

    Billet save(Billet billet);

    void deleteByUuid(String uuid);
}
