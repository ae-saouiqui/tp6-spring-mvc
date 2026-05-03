package services;

import java.util.List;

import dao.ProduitDAO;
import entities.Produit;

public class ProduitServiceImpl implements ProduitService {

    private ProduitDAO dao;

    public ProduitServiceImpl(ProduitDAO dao) {
        this.dao = dao;
    }
    

    @Override
    public void addProduct(Produit p) {
        dao.addProduct(p);
    }

    @Override
    public void deleteProduit(Long p) {
        dao.deleteProduit(p);
    }

    @Override
    public Produit getProduitById(Long id) {
        return dao.findProduitById(id);
    }

    @Override
    public void updateProduit(Produit p) {
        dao.updateProduit(p);
    }

    @Override
    public List<Produit> getAllProduits() {
        return dao.findAllProduits();
    }
}
