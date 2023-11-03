package Entity;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Categorie {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_categorie")
    private int idCategorie;
    @Basic
    @Column(name = "nom_categorie")
    private String nomCategorie;
    @OneToMany(mappedBy = "categorieByCategorieId")
    private Collection<Produit> produitsByIdCategorie;
    @OneToMany(mappedBy = "categorieByCategorieId")
    private Collection<Promotion> promotionsByIdCategorie;
    @OneToMany(mappedBy = "categorieByCategorieId")
    private Collection<Rayonadmin> rayonadminsByIdCategorie;

    public int getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(int idCategorie) {
        this.idCategorie = idCategorie;
    }

    public String getNomCategorie() {
        return nomCategorie;
    }

    public void setNomCategorie(String nomCategorie) {
        this.nomCategorie = nomCategorie;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Categorie categorie = (Categorie) o;

        if (idCategorie != categorie.idCategorie) return false;
        if (nomCategorie != null ? !nomCategorie.equals(categorie.nomCategorie) : categorie.nomCategorie != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idCategorie;
        result = 31 * result + (nomCategorie != null ? nomCategorie.hashCode() : 0);
        return result;
    }

    public Collection<Produit> getProduitsByIdCategorie() {
        return produitsByIdCategorie;
    }

    public void setProduitsByIdCategorie(Collection<Produit> produitsByIdCategorie) {
        this.produitsByIdCategorie = produitsByIdCategorie;
    }

    public Collection<Promotion> getPromotionsByIdCategorie() {
        return promotionsByIdCategorie;
    }

    public void setPromotionsByIdCategorie(Collection<Promotion> promotionsByIdCategorie) {
        this.promotionsByIdCategorie = promotionsByIdCategorie;
    }

    public Collection<Rayonadmin> getRayonadminsByIdCategorie() {
        return rayonadminsByIdCategorie;
    }

    public void setRayonadminsByIdCategorie(Collection<Rayonadmin> rayonadminsByIdCategorie) {
        this.rayonadminsByIdCategorie = rayonadminsByIdCategorie;
    }
}
