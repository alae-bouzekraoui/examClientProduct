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
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String description;
    private Float prix;
    private int quantiteStock;

    @OneToMany(mappedBy = "produit", fetch = FetchType.LAZY)
    private List<LigneCommande> lignesCommande;
}
