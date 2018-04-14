package tp4;


public class Produit {
	private int id; private String nomP;
	private double prix; private int Qte;
	private Categorie categorie;
	public Produit(int id, String nomP, double prix, int qte, int idCateg ) {
		super();
		this.id = id;
		this.nomP = nomP;
		this.prix = prix;
		Qte = qte;
	}
	public Produit() {
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNomP() {
		return nomP;
	}
	public void setNomP(String nomP) {
		this.nomP = nomP;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public int getQte() {
		return Qte;
	}
	public void setQte(int qte) {
		Qte = qte;
	}
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
}
