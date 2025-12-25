package ma.xproce.exam.web;

import ma.xproce.exam.dao.entities.Commande;
import ma.xproce.exam.dao.entities.LigneCommande;
import ma.xproce.exam.dao.entities.Produit;
import ma.xproce.exam.service.ICommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.ArrayList;
import java.util.List;
import org.springframework.ui.Model;

@Controller
public class CommandeController {

    @Autowired
    private ICommandeService commandeService;

    @GetMapping("commandes/nouvelle")
    public String formulaireCommande(Model model) {
        model.addAttribute("produits", commandeService.getProduitsDisponibles());
        return "commande-form";
    }

    @PostMapping("/commandes/nouvelle")
    public String passerCommande(@RequestParam Long clientId,
                                 @RequestParam List<Long> produitIds,
                                 @RequestParam List<Integer> quantites) {

        List<LigneCommande> lignesCommande = new ArrayList<>();

        for (int i = 0; i < produitIds.size(); i++) {
            Produit produit = new Produit();
            produit.setId(produitIds.get(i));

            LigneCommande l = new LigneCommande();
            l.setProduit(produit);
            l.setQuantiteCommande(quantites.get(i));

            lignesCommande.add(l);
        }

        commandeService.passerCommande(clientId, lignesCommande);

        return "redirect:/commandes/client/" + clientId;
    }

    @GetMapping("/client/{clientId}/commandes")
    public String afficherHistorique(@PathVariable Long clientId, Model model) {

        List<Commande> commandes = commandeService.getCommandesByClient(clientId);
        model.addAttribute("commandes", commandes);

        return "historique-commandes";
    }
}
