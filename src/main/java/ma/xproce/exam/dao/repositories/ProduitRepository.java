package ma.xproce.exam.dao.repositories;

import ma.xproce.exam.dao.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitRepository extends JpaRepository<Produit, Long> {
}
