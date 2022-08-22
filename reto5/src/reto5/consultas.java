package reto5;
//import java.sql.Connection;
//import java.util.ArrayList;
//import java.util.Scanner;
//import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
//import java.util.Scanner;
import java.sql.ResultSet;
import java.sql.Statement;
public class consultas {
    public static void crearTablas(){
        try {
            String[] sqls={
                "CREATE TABLE proveedor(prov_id int PRIMARY KEY,prov_nombre char(20),"
                    + "prov_direccion char(45),prov_telefono char(20))",
                 "CREATE TABLE compras(id int primary key,alias char(20)," 
                    +"fabricante char(20), fecha_hora timestamp, foreign key(fabricante) references fabricantes(fabricante)," 
                    +"foreign key(alias) references clientes(alias))",
                 "CREATE TABLE bicicletas(id int  primary key, fabricante CHAR(20),"
                    + "precio INT,año INT , foreign key(fabricante) references fabricantes(fabricante))",
                 "CREATE TABLE clientes(  alias char(20) PRIMARY KEY, nombre CHAR(20) ," 
                    +"apellido CHAR(20) , celular char(20), email varchar(45) ,contraseña int," 
                    +"f_nacimiento date)",
                 "CREATE TABLE fabricantes(fabricante char(20) primary key)",
                 "CREATE TABLE motocicletas( id int  primary key, fabricante CHAR(20) ," 
                    +"precio INT, autonomia int,id_prov int, foreign key(fabricante) references fabricantes(fabricante)," 
                    +"foreign key(id_prov) references proveedor(prov_id)) ",
            };
            for(String i:sqls){
            PreparedStatement statement=ConexionBD.conectarBD().prepareStatement(i);
                    statement.executeUpdate();
            }
         }catch(Exception ex){
            System.out.println("Tablas ya creadas ");
        }
    }
    public static boolean modificarAño(){
         int filasAfectadas = 0;
        String sql ="UPDATE bicicletas SET año=? WHERE fabricante=?";
   
        try {
        PreparedStatement statement = ConexionBD.conectarBD().prepareStatement(sql);
      
        
         System.out.println("Ingrese fabricantes de la bicicleta y el año a modificar. ");
         
        System.out.println("Fabricante: ");
        String nombre= Reto5.sc.nextLine();
        statement.setString(2,nombre);
        
        System.out.println("Año: ");
        int año= Reto5.sc.nextInt();
        statement.setInt(1,año);
        Reto5.sc.nextLine();
        
        
       filasAfectadas = statement.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("ERROR AL MODIFICAR AÑO");
            ex.printStackTrace();

        }
        if (filasAfectadas > 0) {
            return true;
        } else {
            return false;
        }
    }
      public static boolean modificarTelCliente(){
         int filasAfectadas = 0;
        String sql ="UPDATe clientes SET celular=? WHERE alias=?";
   
        try {
        PreparedStatement statement = ConexionBD.conectarBD().prepareStatement(sql);
      
        
         System.out.println("Ingrese alias del cliente y el nuevo numero de celular. ");
         
        System.out.println("Alias: ");
        String alias= Reto5.sc.nextLine();
        statement.setString(2, alias);
        
        System.out.println("Celular: ");
        String celular= Reto5.sc.nextLine();
        statement.setString(1,celular);
        
        
       filasAfectadas = statement.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("ERROR AL MODIFICAR EL NUMERO DE CELULAR");
            ex.printStackTrace();

        }
        if (filasAfectadas > 0) {
            return true;
        } else {
            return false;
        }
    }
       
        public static boolean borrarCompra(){
         int filasAfectadas = 0;
        String sql ="Delete compras WHERE alias=? AND fabricante=?";
   
        try {
        PreparedStatement statement = ConexionBD.conectarBD().prepareStatement(sql);
      
        
         System.out.println("Ingrese alias del cliente y fabricante. ");
         
        System.out.println("Fabricante: ");
        String nombre= Reto5.sc.nextLine();
        statement.setString(2,nombre);
        
        System.out.println("Alias: ");
        String alias= Reto5.sc.nextLine();
        statement.setString(1,alias);
        
        
       filasAfectadas = statement.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("ERROR AL ELIMINAR COMPRA");
            ex.printStackTrace();

        }
        if (filasAfectadas > 0) {
            return true;
        } else {
            return false;
        }
    }  
        
    public static void consultaFabricantes(){
        String sql ="SELECT fabricante FROM fabricantes ORDER BY fabricante";
   
        try {
        Statement statement = ConexionBD.conectarBD().createStatement();
        ResultSet consulta=statement.executeQuery(sql);
        while(consulta.next()){
            String col1=consulta.getNString(1);
            System.out.println(col1);
        }

        } catch (SQLException ex) {
            System.out.println("ERROR AL REALIZAR CONSULTA. ");
            ex.printStackTrace();

        }
    }
        public static void consultaBiciFab(){
            System.out.println("Ingrese año");
        System.out.print("Año: ");
        int año=Reto5.sc.nextInt();
        Reto5.sc.nextLine();
        
            String sql ="SELECT count(fabricante) FROM bicicletas WHERE año>="+año;
         
        try {
        Statement statement = ConexionBD.conectarBD().createStatement();
        ResultSet consulta=statement.executeQuery(sql);
        while(consulta.next()){
            int col1=consulta.getInt(1);
            System.out.println(col1);
        }

        } catch (SQLException ex) {
            System.out.println("ERROR AL REALIZAR CONSULTA. ");
            ex.printStackTrace();

        }
        }
         public static void consultaCompBiCli(){
          String sql ="SELECT c.alias,c.nombre,c.apellidos FROM clientes c, compras p where c.alias=p.alias and p.fabricante=\"Yeti\" order by nombre";
         
        try {
        Statement statement = ConexionBD.conectarBD().createStatement();
        ResultSet consulta=statement.executeQuery(sql);
        while(consulta.next()){
            String col1=consulta.getString(1);
            String col2=consulta.getString(2);
            String col3=consulta.getString(3);
            System.out.println(col1+" "+col2+" "+col3);
        }

        } catch (SQLException ex) {
            System.out.println("ERROR AL REALIZAR CONSULTA. ");
            ex.printStackTrace();

        }
        }
           public static void consultaCompBiMo(){
          String sql ="SELECT fabricante FROM  compras  where alias=\"lucky\" order by fabricante";
         
        try {
        Statement statement = ConexionBD.conectarBD().createStatement();
        ResultSet consulta=statement.executeQuery(sql);
        while(consulta.next()){
            String col1=consulta.getString(1);
            
            System.out.println(col1);
        }

        } catch (SQLException ex) {
            System.out.println("ERROR AL REALIZAR CONSULTA. ");
            ex.printStackTrace();

        }
        }
             public static void consultaFabriMoto(){
          String sql ="SELECT fabricante FROM clientes where id_prov=101";
         
        try {
        Statement statement = ConexionBD.conectarBD().createStatement();
        ResultSet consulta=statement.executeQuery(sql);
        while(consulta.next()){
            String col1=consulta.getString(1);
            
            System.out.println(col1);
        }

        } catch (SQLException ex) {
            System.out.println("ERROR AL REALIZAR CONSULTA. ");
            ex.printStackTrace();

        }
       }
               public static void consultaInfoBici(){
          String sql ="SELECT }fabricante,precio,año FROM bicicletas  where año>=2019 order by fabricante";
         
        try {
        Statement statement = ConexionBD.conectarBD().createStatement();
        ResultSet consulta=statement.executeQuery(sql);
        while(consulta.next()){
            String col1=consulta.getString(1);
            int col2=consulta.getInt(2);
            String col3=consulta.getString(3);
            System.out.println(col1+" "+col2+" "+col3);
        }

        } catch (SQLException ex) {
            System.out.println("ERROR AL REALIZAR CONSULTA. ");
            ex.printStackTrace();

        }
               }
             
             
}
    

