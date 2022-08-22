
package reto5;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Scanner;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Reto5 {
    public static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
     //ConexionBD.conectarBD();
     menu();
    }
     public static void menu(){
     
try {
            System.out.println("************************\n" +
                    "***   CRUD  MySQL   ***\n" +
                    "************************\n" +
                    "1. Crear Tablas.\n" +
                    "----------------------------------------------------------------------\n" +
                    "2. Ingresar datos Tabla Proveedor.\n" +
                    "3. Ingresar datos Tabla Clientes.\n" +
                    "4. Ingresar datos Tabla Fabricantes.\n" +
                    "5. Ingresar datos Tabla Bicicletas.\n" +
                    "6. Ingresar datos Tabla Motocicletas.\n" +
                    "7. Ingresar datos Tabla Compras.\n" +
                    "----------------------------------------------------------------------\n" +
                    "8. Modificar Año de Bicicleta.\n" +
                    "9. Modificar Telefono de Cliente.\n" +
                    "10. Borrar intención de compra.\n" +
                    "----------------------------------------------------------------------\n" +
                    "11. Listado de Fabricantes.\n" +
                    "12. Mostrar información fabricantes Bicicletas estrenadas desde 2019.\n" +
                    "13. Mostrar fabricantes motocicletas con motor Auteco.\n" +
                    "14. Mostrar fabricante intencion de Compra del cliente lucky.\n" +
                    "15. Mostrar Clientes que quieren comprar bicicleta Yeti.\n" +
                    "16. Cantidad bicicletas fabricadas desde \"x\" Año.\n" +
                    "----------------------------------------------------------------------\n" +
                    "- Otro número para SALIR -\n"+
                    "----------------------------------------------------------------------\n"
            );
            System.out.print(">> ");
            String input = sc.nextLine();
            byte opcion = Byte.parseByte(input);

            switch (opcion) {
                case 1:
                    consultas.crearTablas();
                    break;
                case 2:
                    proveedor.ingresarProveedor();
                    break;
                case 3:
                    clientes.ingresarClientes();
                    break;
                case 4:
                    fabricantes.ingresarFabricantes();
                    break;
                case 5:
                    bicicletas.ingresarBicicletas();
                    break;
                case 6:
                    motocicletas.ingresarMotocicletas();
                    break;
                case 7:
                    compras.ingresarCompras();
                    break;
                case 8:
                    consultas.modificarAño();
                    break;
                case 9:
                    consultas.modificarTelCliente();
                    break;
                case 10:
                    consultas.borrarCompra();
                    break;
                case 11:
                    consultas.consultaFabricantes();
                    break;
                case 12:
                    consultas.consultaInfoBici();
                    break;
                case 13:
                    consultas.consultaFabriMoto();
                    break;
                case 14:
                    consultas.consultaCompBiMo();
                    break;
                case 15:
                    consultas.consultaCompBiCli();
                    break;
                case 16:
                    consultas.consultaBiciFab();
                    break;
                default:
                    System.out.println("Hasta Pronto...");
            }
        } catch (Exception ex) {
            System.out.println("Hasta Pronto...");
        }
 }

   
}
