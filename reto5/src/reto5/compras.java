
package reto5;
import java.sql.Connection;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.SQLException;
//import java.util.ArrayList;
public class compras {
     public static boolean ingresarCompras() {
        int filasAfectadas = 0;
        String sqlCompras = "INSERT INTO compras VALUES (?, ?, ?, ?)";
   
        try {
        PreparedStatement statementCompras = ConexionBD.conectarBD().prepareStatement(sqlCompras);
        System.out.println("Id:");
        int id= Reto5.sc.nextInt();
        statementCompras.setInt(1,id);
        Reto5.sc.nextLine();
        
        System.out.println("Alias: ");
        String alias= Reto5.sc.nextLine();
        statementCompras.setString(2,alias);
        
        System.out.println("Fabricante: ");
        String fabricante= Reto5.sc.nextLine();
        statementCompras.setString(2,fabricante);
        
        System.out.println("fecha_hora: ");
        String fecha_hora= Reto5.sc.nextLine();
        statementCompras.setString(3,fecha_hora);
        
        
        
            
     
          

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
