
package reto5;
import java.sql.Connection;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.SQLException;
//import java.util.ArrayList;
import java.util.Scanner;
public class clientes {
    public static Scanner sc=new Scanner(System.in);
    public static boolean ingresarClientes() {
        int filasAfectadas = 0;
        String sql = "INSERT INTO clientes VALUES (?, ?, ?, ?, ?, ?, ?)";
   
        try {
        PreparedStatement statement = ConexionBD.conectarBD().prepareStatement(sql);
        
        System.out.println("Alias:");
        String alias= Reto5.sc.nextLine();
        statement.setString(1,alias);
        
        System.out.println("Nombre:");
        String nombre= Reto5.sc.nextLine();
        statement.setString(2,nombre);
       
        System.out.println("Apellidos: ");
        String apellidos= Reto5.sc.nextLine();
        statement.setString(3,apellidos);
        
        System.out.println("Email: ");
        String email= Reto5.sc.nextLine();
        statement.setString(4,email);
        
        System.out.println("Celular: ");
        String celular= Reto5.sc.nextLine();
        statement.setString(5,celular);
        
        System.out.println("Contraseña: ");
        int contraseña= Reto5.sc.nextInt();
        Reto5.sc.nextLine();
        statement.setInt(6,contraseña);
        
        System.out.println("fecha_nacimiento: ");
        String f_nacimiento= Reto5.sc.nextLine();
        statement.setString(7,f_nacimiento);
        
        filasAfectadas = statement.executeUpdate();

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

