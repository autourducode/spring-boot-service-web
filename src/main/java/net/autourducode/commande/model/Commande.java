package net.autourducode.commande.model;

import javax.annotation.processing.Generated;
import javax.persistence.*;
import java.util.Objects;

/**
 * @author rickenbazolo
 */
@Entity
@Table(name = "commandes")
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nom;
    private int quantite;
    private double prix;

    public Commande() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Commande commande = (Commande) o;
        return quantite == commande.quantite && Double.compare(commande.prix, prix) == 0
                && id.equals(commande.id) && nom.equals(commande.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nom, quantite, prix);
    }
}
