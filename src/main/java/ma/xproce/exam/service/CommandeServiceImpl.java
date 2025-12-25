package ma.xproce.exam.service;

import ma.xproce.exam.dao.entities.*;
import ma.xproce.exam.dao.repositories.ClientRepository;
import ma.xproce.exam.dao.repositories.CommandeRepository;
import ma.xproce.exam.dao.repositories.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommandeServiceImpl implements ICommandeService {

    @Autowired
    private CommandeRepository commandeRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ProduitRepository produitRepository;

    @Override
    public Produit updateProductStock(Long produitId, int quantityChange) {
        Produit produit = produitRepository.findById(produitId).orElse(null);
        if (produit != null) {
            if (produit.getQuantiteStock() + quantityChange > 0) {
                produit.setQuantiteStock(produit.getQuantiteStock() + quantityChange);
            }else{
                throw new RuntimeException("valeur de quantite invalide");
            }
        } else {
            throw new RuntimeException("Produit introuvable");
        }
        return produitRepository.save(produit);
    }

    @Override
    public Commande passerCommande(Long clientId, List<LigneCommande> lignesCommande) {
        Client client = clientRepository.findById(clientId).orElse(null);
        Commande commande = new Commande();
        if (client != null) {
            commande.setClient(client);
            commande.setLignesCommande(lignesCommande);
            commande.setStatut(Statut.EN_ATTENTE);
        }else{
            throw new RuntimeException("Client introuvable");
        }

        for (LigneCommande l : lignesCommande) {
            Produit produit = l.getProduit();
            if(produit.getQuantiteStock() > 0){
                produit.setQuantiteStock(produit.getQuantiteStock() - l.getQuantiteCommande());
                produitRepository.save(produit);
            }else{
                throw new RuntimeException("Produit en rupture de stock: " + produit.getNom());
            }
        }
        return commandeRepository.save(commande);
    }

    @Override
    public List<Commande> getCommandesByClient(Long clientId) {
        return commandeRepository.findByClientId(clientId);
    }

    @Override
    public List<Produit> getProduitsDisponibles() {
        return produitRepository.findAll();
    }
}
