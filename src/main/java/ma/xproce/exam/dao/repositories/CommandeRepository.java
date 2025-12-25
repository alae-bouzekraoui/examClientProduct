package ma.xproce.exam.dao.repositories;

import ma.xproce.exam.dao.entities.Commande;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommandeRepository extends JpaRepository<Commande, Long> {
    List<Commande> findByClientId(Long clientId);
}
