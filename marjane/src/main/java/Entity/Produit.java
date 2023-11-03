package Entity;

import jakarta.persistence.*;

import java.math.BigInteger;
import java.util.Collection;

@Entity
public class Produit {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_produit")
    private int idProduit;
    @Basic
    @Column(name = "nom_produit")
    private String nomProduit;
    @Basic
    @Column(name = "quantite")
    private int quantite;
    @Basic
    @Column(name = "prix")
    private BigInteger prix;
    @Basic
    @Column(name = "categorie_id")
    private Integer categorieId;
    @ManyToOne
    @JoinColumn(name = "categorie_id", referencedColumnName = "id_categorie")
    private Categorie categorieByCategorieId;
    @OneToMany(mappedBy = "produitByProduitId")
    private Collection<Promotion> promotionsByIdProduit;

    public int getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(int idProduit) {
        this.idProduit = idProduit;
    }

    public String getNomProduit() {
        return nomProduit;
    }

    public void setNomProduit(String nomProduit) {
        this.nomProduit = nomProduit;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public BigInteger getPrix() {
        return prix;
    }

    public void setPrix(BigInteger prix) {
        this.prix = prix;
    }

    public Integer getCategorieId() {
        return categorieId;
    }

    public void setCategorieId(Integer categorieId) {
        this.categorieId = categorieId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Produit produit = (Produit) o;

        if (idProduit != produit.idProduit) return false;
        if (quantite != produit.quantite) return false;
        if (nomProduit != null ? !nomProduit.equals(produit.nomProduit) : produit.nomProduit != null) return false;
        if (prix != null ? !prix.equals(produit.prix) : produit.prix != null) return false;
        if (categorieId != null ? !categorieId.equals(produit.categorieId) : produit.categorieId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idProduit;
        result = 31 * result + (nomProduit != null ? nomProduit.hashCode() : 0);
        result = 31 * result + quantite;
        result = 31 * result + (prix != null ? prix.hashCode() : 0);
        result = 31 * result + (categorieId != null ? categorieId.hashCode() : 0);
        return result;
    }

    public Categorie getCategorieByCategorieId() {
        return categorieByCategorieId;
    }

    public void setCategorieByCategorieId(Categorie categorieByCategorieId) {
        this.categorieByCategorieId = categorieByCategorieId;
    }

    public Collection<Promotion> getPromotionsByIdProduit() {
        return promotionsByIdProduit;
    }

    public void setPromotionsByIdProduit(Collection<Promotion> promotionsByIdProduit) {
        this.promotionsByIdProduit = promotionsByIdProduit;
    }
}
