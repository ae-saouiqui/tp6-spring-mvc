package controllers;


import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import entities.Produit;
import services.ProduitService;


@Controller
@RequestMapping("/produits")
public class ProduitController {

    private ProduitService service;

    public ProduitController(ProduitService service){
        this.service = service;
    }


    @GetMapping("/list")
    public String ListProduits(Model model){
        List<Produit> produits  = service.getAllProduits(); 
        model.addAttribute("Produits",produits);
        return "home";
    }

    @GetMapping("/get")
    public String getProduit(@RequestParam(name="id",defaultValue="0") Long id,Model model){
        Produit p = service.getProduitById(id);
        if (p!=null){
            model.addAttribute("Produits", List.of(p));
            return "home";
        }else return "redirect:/produits/list";
        
    }

    @PostMapping("/add")
    public String createProduit(@ModelAttribute("produit") Produit produit){
        this.service.addProduct(produit);
        return "redirect:/produits/list";
    }

    @PostMapping("/update")
    public String updateProduct(@ModelAttribute ("produit") Produit produit){
        this.service.updateProduit(produit);
        return "redirect:/produits/list";
    }

    @GetMapping("/delete")
    public String deletePorduct(@RequestParam("id") Long id){
        this.service.deleteProduit(id);
        return "redirect:/produits/list";
    }

    @GetMapping("/edit")
    public String preparEdit(@RequestParam("id") Long id,Model model){
        Produit p = this.service.getProduitById(id);
        model.addAttribute("produitEdit",p);
        return "forward:/produits/list";
       }
}
