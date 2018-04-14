package tp4;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class Connexion {

	//public final class singletonConnection {
		
		private Connection con;
		private static Connection connect;
		private void Connexion() {
			String url;
			try {
				Class.forName("org.postgresql.Driver");
				System.out.println("Chargement du Driver ok");
				
			}catch (Exception e) {
				System.out.println(e.toString());
			}
			
			url="jdbc:postgresql://localhost:5432/GestionProduit";
			try {
				connect=DriverManager.getConnection(url, "postgres", "postgres");
				System.out.println("Connexion bdd ok!!");
				
			}catch(SQLException ex) {
				System.out.println(ex.toString());
			}
		}
		
		public Connection getcon() {
			return con;
		}
		public static Connection getInstance() {
			if(connect==null) {
				new Connexion();
			}
				
			return connect;
		}
  }
	
//}
