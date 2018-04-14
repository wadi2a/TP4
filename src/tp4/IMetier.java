package tp4;



import java.util.List;

public interface IMetier {
	public void AjouterC(Categorie c);
	public void AjouterP(Produit p, int id);
	public List<Produit> ConsulterP(String word);
	public List<Categorie> ConsulterC();
	public List<Produit> ConsulterPByCode(int code);
	public Categorie ConsulterCByCode(int code);
}
