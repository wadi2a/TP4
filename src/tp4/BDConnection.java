package tp4;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BDConnection {
	 Connection connect ;
    Statement statement;
    /**
     * La classe dbConnect sert a se connecter a la base de donner avec la variable connect et le drive sql 
     * et elle crée un statement par defaut et l'affecte a la variable statement de la classe
     * (la variable statement c'est l'environnement sql pour executer nos requette a chaque fois 
     * a l'aide de statement.executeQuery(string)/executeUpdate()
     */
    public BDConnection()
	{
	    try {
                  Class.forName("com.mysql.jdbc.Driver");
	          Connection  conn;
                conn = DriverManager.getConnection("jdbc:mysql://gdev.eb2a.com/eb2a_21845942_School","eb2a_21845942", "gdevmiage2018");
                  this.statement =  conn.createStatement();  
                } catch (ClassNotFoundException | SQLException e) {
	    }
		  
	}
    /**
     *  methode pour les statement Insert update delete...
     * @param requette // Requette de type String a executer
     * @return  // nombre de ligne infecter par la modification
     * @throws SQLException 
     */
    public int modifyDbQuery(String requette) throws SQLException {
        return this.statement.executeUpdate(requette);
    }
      /**
     *  methode pour le statement select
     * @param requette // Requette de type String a executer
     * @return  // nombre de ligne infecter par la modification
     * @throws SQLException 
     */
    public ResultSet extractDbQuery(String requette) throws SQLException {
        return this.statement.executeQuery(requette);
    }
         /**
     *  methode pour les autres statement avec avec un type de retour void1
     * @param requette // Requette de type String a executer
     * @return  // elle ne retourne rien 
     * @throws SQLException 
     */
    public void manipDbQuery(String requette) throws SQLException {
         this.statement.execute(requette);
    }
    
    
    
	}


