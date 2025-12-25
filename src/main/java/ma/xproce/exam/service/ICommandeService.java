package ma.xproce.exam.service;
import ma.xproce.exam.dao.entities.Commande;
import ma.xproce.exam.dao.entities.LigneCommande;
import ma.xproce.exam.dao.entities.Produit;

import java.util.List;

public interface ICommandeService {

    Produit updateProductStock(Long produitId, int quantityChange);

    Commande passerCommande(Long clientId, List<LigneCommande> lignesCommande);

    List<Commande> getCommandesByClient(Long clientId);

    List<Produit> getProduitsDisponibles();

}
