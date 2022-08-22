
package reto5;
import java.sql.Connection;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.SQLException;
//import java.util.ArrayList;
public class proveedor {
     public static boolean ingresarProveedor() {
        int filasAfectadas = 0;
        String sqlProv = "INSERT INTO proveedor VALUES (?, ?, ?, ?)";
   
        try {
        PreparedStatement statementProv = ConexionBD.conectarBD().prepareStatement(sqlProv);
       
        System.out.println("Prov_id:");
        int prov_id= Reto5.sc.nextInt();
        Reto5.sc.nextLine();
        statementProv.setInt(1,prov_id);
        
        System.out.println("nombre_prov: ");
        String prov_nombre = Reto5.sc.nextLine();
        statementProv.setString(2,prov_nombre);
        
        System.out.println("direccion_prov: ");
        String prov_direccion= Reto5.sc.nextLine();
        statementProv.setString(3,prov_direccion);
        
        System.out.println("telefono_prov: ");
        String prov_telefono= Reto5.sc.nextLine();
        statementProv.setString(4,prov_telefono);
     
        
        filasAfectadas = statementProv.executeUpdate();
            
     
          

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
