package ma.xproce.exam.dao.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private Statut statut;

    @ManyToOne
    private Client client;

    @OneToMany(mappedBy = "commande", fetch = FetchType.LAZY)
    private List<LigneCommande> lignesCommande;
}
