
package reto5;
import java.sql.Connection;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.SQLException;
//import java.util.ArrayList;
public class motocicletas {
     public static boolean ingresarMotocicletas() {
        int filasAfectadas = 0;
        String sqlMoto = "INSERT INTO motocicletas VALUES (?, ?, ?, ?,?)";
   
        try {
        PreparedStatement statementMoto = ConexionBD.conectarBD().prepareStatement(sqlMoto);
       
        System.out.println("Id:");
        int id= Reto5.sc.nextInt();
        Reto5.sc.nextLine();
        statementMoto.setInt(1,id);
        
        System.out.println("Fabricante: ");
        String fabricante= Reto5.sc.nextLine();
        statementMoto.setString(2,fabricante);
        
        System.out.println("Precio: ");
        int precio= Reto5.sc.nextInt();
        Reto5.sc.nextLine();
        statementMoto.setInt(3,precio);
        
        System.out.println("Autonomia: ");
        int autonomia= Reto5.sc.nextInt();
        statementMoto.setInt(4,autonomia);
        Reto5.sc.nextLine();
       
        System.out.println("Id_prov: ");
        int id_prov= Reto5.sc.nextInt();
        statementMoto.setInt(4,id_prov);
        Reto5.sc.nextLine();
        
        filasAfectadas = statementMoto.executeUpdate();
            
     
          

        } catch (SQLException ex) {
            System.out.println("ERROR AL INGRESAR MOTOCICLETA");
            ex.printStackTrace();

        }
        if (filasAfectadas > 0) {
            return true;
        } else {
            return false;
        }
    }
}
