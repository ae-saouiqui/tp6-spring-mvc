package entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PRODUITS")
public class Produit {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;


    private String nom;
    private String description;
    private Double prix;


    public Produit(){}
    public Produit(String nom,String description,Double prix){
        this.nom = nom;
        this.description = description;
        this.prix = prix;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setNom(String nom){
        this.nom = nom;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public void setPrix(Double prix){
        this.prix = prix;
    }

    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrix() {
        return prix;
    }
}
