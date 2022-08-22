
package reto5;
import java.sql.Connection;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.SQLException;
//import java.util.ArrayList;
public class bicicletas {
    public static boolean ingresarBicicletas() {
        int filasAfectadas = 0;
        String sqlBici = "INSERT INTO bicicletas VALUES (?, ?, ?, ?)";
   
        try {
        PreparedStatement statementBici = ConexionBD.conectarBD().prepareStatement(sqlBici);
       
        System.out.println("Id:");
        int id= Reto5.sc.nextInt();
        Reto5.sc.nextLine();
        statementBici.setInt(1,id);
        
        System.out.println("Fabricante:");
        String fabricante= Reto5.sc.nextLine();
        statementBici.setString(2,fabricante);
        
        System.out.println("Precio: ");
        int precio= Reto5.sc.nextInt();
        Reto5.sc.nextLine();
        statementBici.setInt(3,precio);
        
        System.out.println("Año: ");
        int año= Reto5.sc.nextInt();
        statementBici.setInt(4,año);
        Reto5.sc.nextLine();
       
        filasAfectadas = statementBici.executeUpdate();
            
     
          

        } catch (SQLException ex) {
            System.out.println("ERROR AL INGRESAR BICICLETAS");
            ex.printStackTrace();

        }
        if (filasAfectadas > 0) {
            return true;
        } else {
            return false;
        }
    }
}
