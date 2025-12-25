package ma.xproce.exam.service;

import ma.xproce.exam.dao.entities.Produit;
import ma.xproce.exam.dao.repositories.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProduitServiceImpl implements IProduitService {

    @Autowired
    private ProduitRepository produitRepository;

    public Produit getProduitById(Long id) {
        return  produitRepository.getById(id);
    }
}
