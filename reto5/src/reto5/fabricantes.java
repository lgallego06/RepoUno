
package reto5;
import java.sql.Connection;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.SQLException;
//import java.util.ArrayList;
public class fabricantes {
      public static boolean ingresarFabricantes() {
        int filasAfectadas = 0;
        String sqlFabri = "INSERT INTO fabricantes VALUES (?)";
   
        try {
        PreparedStatement statementFabri = ConexionBD.conectarBD().prepareStatement(sqlFabri);
      
        
        System.out.println("Fabricante: ");
        String fabricante= Reto5.sc.nextLine();
        statementFabri.setString(2,fabricante);
        
       
        
        
       filasAfectadas = statementFabri.executeUpdate();
            
     
          

        } catch (SQLException ex) {
            System.out.println("ERROR AL INGRESAR CLIENTE");
            ex.printStackTrace();

        }
        if (filasAfectadas > 0) {
            return true;
        } else {
            return false;
        }
    }
}
