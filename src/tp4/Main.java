package tp4;


import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Categorie cat = new Categorie(1,"Cosmetiques");
		Categorie cat1 = new Categorie(1,"Cosmetiques");
		Categorie cat2 = new Categorie(1,"Cosmetiques");
		System.out.println(cat.toString());
		System.out.println(cat1.toString());
		System.out.println(cat2.toString());*/
		Scanner clavier=new Scanner(System.in); 
		System.out.print("Mot Cl�:"); 
		String mc=clavier.nextLine();
		Metier metier=new Metier(); 
		List <Produit> listP=metier.ConsulterP(mc); 
		for(Produit prod:listP) 
			System.out.println(prod.getId()+ "\t Nom:"+prod.getNomP()+"\t Prix:"+prod.getPrix()+ "\t Quantit�:" +prod.getQte()+ "\t Nom Categorie:"+ prod.getCategorie().getNom());
		System.out.println("***************La liste des Categories**********************");
		List <Categorie> cat = metier.ConsulterC();
		for(Categorie c : cat)
			//System.out.println(c.toString());
			System.out.println("Code:"+c.getCode() + "\t Nom:" + c.getNom());
		
		System.out.print("Nom de la categorie: \n"); 
		String name=clavier.nextLine();
		
		//metier.AjouterC(name);
		Categorie categorie = new Categorie(name);
		metier.AjouterC(categorie);
				
		System.out.println("***************Ajouter un produit**********************");
		Categorie ca = new Categorie();
		System.out.println("Id produit: \n"); 
		int id=clavier.nextInt();
		System.out.println("Nom produit: \n"); 
                
		 name = clavier.next();
		System.out.println("Prix: \n"); 
		double prix=clavier.nextDouble();
		System.out.println("Quantit�: \n"); 
		int qte=clavier.nextInt();
		System.out.println("Code: \n"); 
		int cod=clavier.nextInt();
		Produit p = new Produit(id,name,prix,qte,cod);
		metier.AjouterP(p, cod);
		
		System.out.println("***************Afficher la listes des produits par code categorie**********************");
		
		System.out.println("Saisir le code de la cat�gorie:"); 
		int code=clavier.nextInt(); 
		List <Produit> listProd=metier.ConsulterPByCode(code);
		
		
		for(Produit prod:listProd) 
			System.out.println(prod.getId()+ "\t Nom:"+prod.getNomP()+"\t Prix:"+prod.getPrix()+ "\t Quantit�:" +prod.getQte() + "\t Code categorie:" 
	 	+prod.getCategorie().getCode() + "\t Nom categorie:" +prod.getCategorie().getNom());
		//****************************************************
                System.out.println("***************Afficher la liste d'une categorie et ses produits par code categorie**********************");
		
		System.out.println("Saisir le code de la cat�gorie:"); 
		int codeCateg=clavier.nextInt(); 
		Categorie categ=metier.ConsulterCByCode(codeCateg); 
		//System.out.println(categ.toString());
		List<Produit> produ = categ.getProduits();
		for(Produit prod : produ) {
			System.out.println("Code:"+categ.getCode() + "\t Nom:" + categ.getNom() + "\t Nom Produit:"+ prod.getNomP());	
		}
	    }

	}
