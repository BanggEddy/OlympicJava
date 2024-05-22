package fr.efrei.test.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.efrei.test.dto.billet.CreateBillet;
import fr.efrei.test.dto.billet.UpdateBillet;
import fr.efrei.test.model.Billet;
import fr.efrei.test.repository.BilletRepository;
import jakarta.transaction.Transactional;

@Service
public class BilletService {
    private final BilletRepository repository;

    @Autowired
    public BilletService(BilletRepository repository) {
        this.repository = repository;
    }

    public List<Billet> findAllBillet() {
        return repository.findAllByDeletedAtNull();
    }

    public Billet findBilletById(String uuid) {
        return repository.findOneByUuid(uuid).orElse(null);
    }

    public Billet create(CreateBillet billetDto) {
        Billet billetACreer = new Billet(
                billetDto.getPrix(),
                billetDto.getQuantity(),
                billetDto.getReduction(),
                billetDto.getUser(),
                billetDto.getEpreuve(),
                billetDto.getCreatedAt());
        return repository.save(billetACreer);
    }

    @Transactional
    public boolean delete(String uuid) {
        Billet billetASupprimer = findBilletById(uuid);
        if (billetASupprimer != null && billetASupprimer.getDeletedAt() == null) {
            billetASupprimer.setDeletedAt(LocalDateTime.now());
            repository.save(billetASupprimer);
            return true;
        }
        return false;
    }

    public boolean update(String uuid, UpdateBillet billet) {
        Billet billetAModifier = findBilletById(uuid);

        if (billetAModifier != null) {
            billetAModifier.setPrix(billet.getPrix());
            billetAModifier.setQuantity(billet.getQuantity());
            billetAModifier.setReduction(billet.getReduction());
            billetAModifier.setUser(billet.getUser());
            billetAModifier.setEpreuve(billet.getEpreuve());
            billetAModifier.setCreatedAt(billet.getCreatedAt());
            repository.save(billetAModifier);
            return true;
        }
        return false;
    }

    public boolean updatePartielle(String uuid, UpdateBillet billet) {
        Billet billetAModifier = findBilletById(uuid);

        if (billetAModifier != null) {
            if (billet.getPrix() != null) {
                billetAModifier.setPrix(billet.getPrix());
            }
            if (billet.getQuantity() != null) {
                billetAModifier.setQuantity(billet.getQuantity());
            }
            if (billet.getReduction() != null) {
                billetAModifier.setReduction(billet.getReduction());
            }
            if (billet.getUser() != null) {
                billetAModifier.setUser(billet.getUser());
            }
            if (billet.getEpreuve() != null) {
                billetAModifier.setEpreuve(billet.getEpreuve());
            }
            repository.save(billetAModifier);
            return true;
        }
        return false;
    }
}
