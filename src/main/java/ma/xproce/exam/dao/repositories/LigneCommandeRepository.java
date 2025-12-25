package ma.xproce.exam.dao.repositories;

import ma.xproce.exam.dao.entities.LigneCommande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LigneCommandeRepository extends JpaRepository<LigneCommande, Long> {
}
