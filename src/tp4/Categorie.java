package tp4;


import java.util.ArrayList;
import java.util.List;
public class Categorie {
	private int code; private static int nbr=0;
	private String nom;
	private List <Produit> produits = new ArrayList<Produit>();
	public Categorie(String nom) {
		super();
		nbr++;
		this.code = nbr;
		this.nom = nom;
	}
	public Categorie(int code, String nom) {
		super();
		if(this.code < nbr) { this.code = nbr;}
		nbr++;
		this.code = code;
		nbr = code + 1 ;
		this.nom = nom;
	}
	public Categorie() {
	}
	public List<Produit> getProduits() {
		return produits;
	}
	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
@Override
	public String toString() {
		return "le code:"+ this.code +"le nom:"+ this.nom + "Produits:"+ this.produits;
	}
}
