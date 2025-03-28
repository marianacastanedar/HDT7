import java.util.HashMap;

public class Producto {
    private String sku;
    private String nombre;
    private String descripcion;
    private HashMap<String, Integer> tallas;

    public Producto(String sku, String nombre, String descripcion, HashMap<String, Integer> tallas) {
        this.sku = sku;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tallas = tallas;
    }

    public String getSKU() {
        return sku;
    }
    
    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public HashMap<String, Integer> getTallas() {
        return tallas;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setTallas(HashMap<String, Integer> tallas) {
        this.tallas = tallas;
    }

    /* tenia este metodo pero se miraban feas las comillas asi que hice el otro, pero es lo mismo
    public String toString() {
        return sku + "\n nombre: " + nombre + " \n descripcion: "  + descripcion + " \n tallas: " + tallas;
    } */

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n nombre: ").append(nombre).append("\n");
        sb.append(" descripcion: ").append(descripcion).append("\n");
        sb.append(" tallas: ");

        for (String talla : tallas.keySet()) {
            sb.append(talla).append("=").append(tallas.get(talla)).append(", ");
        }

        // Elimina la última coma y espacio
        if (!tallas.isEmpty()) {
            sb.setLength(sb.length() - 2);
        }

        return sb.toString();
    }

}
