package ma.xproce.exam.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ma.xproce.exam.dao.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
    Client findByEmail(String email);
}
