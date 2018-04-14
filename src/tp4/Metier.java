package tp4;


import java.sql.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Metier implements IMetier {
	private List <Produit> listP=new ArrayList <Produit>();
	private List<Categorie> listC= new ArrayList <Categorie>();
	public Metier() {
		super();
	}
	public void AjouterC(Categorie c) {
		 BDConnection connection = new BDConnection() ;
	        try {
	        	
                       
                        
	            connection.modifyDbQuery("insert into categorie(nom) values ('"+c.getNom()+"')");
	           
	            System.out.println("Categorie ajout� avec succ�s!!");
	        } catch (SQLException ex) {
	        } finally {
	            try {
	                connection.statement.close();
	            } catch (SQLException ex) {
	                ex.printStackTrace();
	            }
	        }
	    	listC.add(c);
	   }
	public void AjouterP(Produit p, int id) {
		PreparedStatement statement = null;
                BDConnection connection = new BDConnection() ;
            try {
                ResultSet resultat =connection.extractDbQuery("select * from produit where nom_prod like "+id+"");
            } catch (SQLException ex) {
                Logger.getLogger(Metier.class.getName()).log(Level.SEVERE, null, ex);
            }

	        try {
	        	
	           connection.modifyDbQuery("insert into produit(id_prod,nom_prod,prix_prod,qte_prod,code_prod) values ("+p.getId()+",'"+p.getNomP()+"',"+p.getPrix()+","+p.getQte()+","+id+")");
	        } catch (SQLException ex) {
	        ex.printStackTrace();}
	    	listP.add(p);
	}
	public List<Produit> ConsulterP(String word){
		List <Produit> newList = new ArrayList<Produit>();
                BDConnection connection = new BDConnection() ;
		try {
			ResultSet resultat =connection.extractDbQuery("select * from produit where nom_prod like " + word);
			
			
			while(resultat.next()){
				Produit prod = new Produit();
				prod.setId(resultat.getInt("id_prod"));
				prod.setNomP(resultat.getString("nom_prod"));
				prod.setPrix(resultat.getDouble("prix_prod"));
				prod.setQte(resultat.getInt("qte_prod"));
				int idCat = resultat.getInt("code_prod");
				 resultat = connection.extractDbQuery("select * from categorie where code =?");

				if(resultat.next()) {
					Categorie cat = new Categorie();
					cat.setCode(resultat.getInt(1));
					cat.setNom(resultat.getString(2));
					prod.setCategorie(cat);
					resultat.close();
				}  newList.add(prod);
			}
			resultat.close();
		}catch(Exception e) {
			e.printStackTrace(); }
		return newList;
	}
	public List<Categorie> ConsulterC(){
		List <Categorie> newList = new ArrayList<>();
                BDConnection connection = new BDConnection() ;
		try {
		ResultSet resultat=connection.extractDbQuery("select * from categorie");
		
		while(resultat.next()) {
			Categorie cat = new Categorie();
			cat.setCode(resultat.getInt("code"));
			cat.setNom(resultat.getString("nom"));
			newList.add(cat);
		}
		}catch(Exception e) {
			e.printStackTrace(); }
	  return newList;
	}
	public List <Produit> ConsulterPByCode(int code) {
		List <Produit> newList = new ArrayList<Produit>();
                BDConnection connection = new BDConnection() ;
                ResultSet resultat = null;
		try {      
			ResultSet rs= connection.extractDbQuery("select * from produit where code_prod = ?");
			
			while(rs.next()){
				Produit prod = new Produit();
				prod.setId(rs.getInt("id_prod"));
				prod.setNomP(rs.getString("nom_prod"));
				prod.setPrix(rs.getDouble("prix_prod"));
				prod.setQte(rs.getInt("qte_prod"));
				int idCat= rs.getInt("code_prod");
				 resultat = connection.extractDbQuery("select * from categorie where code = "+idCat);
				
				if(resultat.next()) {
					Categorie cat = new Categorie();cat.setCode(resultat.getInt(1));cat.setNom(resultat.getString(2));prod.setCategorie(cat);
					resultat.close();
				}
				newList.add(prod);
				}
			resultat.close();
			
		}catch(Exception e) {
			e.printStackTrace(); }
		return newList;
	}
	public Categorie ConsulterCByCode(int code) {
            BDConnection connection = new BDConnection() ;
		Categorie cat= null;
		try {
			ResultSet resutat= connection.extractDbQuery("select * from categorie where code=?");
		
			if(resutat.next()) {
				cat = new Categorie();
				cat.setCode(resutat.getInt("code")); cat.setNom(resutat.getString("nom"));
					List <Produit> prod =this.ConsulterPByCode(code);
					cat.setProduits(prod); }
			resutat.close();
		}catch(Exception e) { e.printStackTrace(); }
		return cat;
	}
}
