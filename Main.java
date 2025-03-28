// Main.java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Inventario inventario = new Inventario();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- MENU --- \n Eliga la opcion que desee");
            System.out.println("1. Cargar productos desde CSV");
            System.out.println("2. Listar productos por SKU");
            System.out.println("3. Buscar producto por SKU");
            System.out.println("4. Buscar producto por nombre");
            System.out.println("5. Salir");
            System.out.print("Opción: ");
            int op = sc.nextInt();
            sc.nextLine(); // limpiar

            switch (op) {
                case 1:
                    System.out.print("Archivo CSV: ");
                    String archivo = sc.nextLine();
                    inventario.cargarCSV(archivo);
                    break;
                case 2:
                    inventario.listarPorSKU();
                    break;
                case 3:
                    System.out.print("SKU: ");
                    String sku = sc.nextLine();
                    System.out.println(inventario.buscarPorSKU(sku));
                    break;
                case 4:
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.println(inventario.buscarPorNombre(nombre));
                    break;
                case 5:
                    return;
            }
        }
    }
}
