// Inventario.java
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Inventario {
    BinaryTree<String, Producto> arbolPorSKU = new BinaryTree<>();
    BinaryTree<String, Producto> arbolPorNombre = new BinaryTree<>();

    public void cargarCSV(String nombreArchivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                //separa por partes (sku, nombre, descripcion, tallas)
                String[] partes = linea.split(",");
                if (partes.length < 4) continue;

                String sku = partes[0];
                String nombre = partes[1];
                String descripcion = partes[2];
                HashMap<String, Integer> tallas = new HashMap<>();

                //hace el hashmap con las tallas
                String[] tallaPartes = partes[3].split("\\|");
                for (String t : tallaPartes) {
                    String[] tinfo = t.split(":");
                    if (tinfo.length == 2) {
                        //parseInt para convertir string a int
                        tallas.put(tinfo[0], Integer.parseInt(tinfo[1]));
                    }
                }

                Producto producto = new Producto(sku, nombre, descripcion, tallas);
                arbolPorSKU.insert(sku, producto);
                arbolPorNombre.insert(nombre, producto);
            }
        } catch (IOException e) {
            System.out.println("Error leyendo archivo: " + e.getMessage());
        }
    }

    public void listarPorSKU() {
        arbolPorSKU.printOrdenado();
    }

    public void listarPorNombre() {
        arbolPorNombre.printOrdenado();
    }

    public Producto buscarPorSKU(String sku) {
        return arbolPorSKU.buscar(sku);
    }

    public Producto buscarPorNombre(String nombre) {
        return arbolPorNombre.buscar(nombre);
    }
}
