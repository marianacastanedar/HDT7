public class BinaryTree<K extends Comparable<K>, V> {
    private class Node {
        K key;
        V value;
        Node left, right;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node root;

    // Insertar un nodo
    public void insert(K key, V value) {
        root = insertar(root, key, value);
    }

    private Node insertar(Node current, K key, V value) {
        //aca mira si tiene el espacio vacío para poder crear el nodo
        if (current == null)
            return new Node(key, value);

        /*compara con la key actual para ver si es mayor (irá a la derecha) o menor (izquierda)
        usamos recursividad pues queremos ver si el nodo left esta vacio entonces current será null,
        si no repetimos hasta que este el espacio vacio para crear el espacio */
        int comparacion = key.compareTo(current.key);
        if (comparacion < 0) {
            current.left = insertar(current.left, key, value);
        } else if (comparacion > 0) {
            current.right = insertar(current.right, key, value);
        } else {
            current.value = value; // actualiza si ya existe
        }

        return current;
    }

    // Buscar por clave
    public V buscar(K key) {
        return busqueda(root, key);
    }

    private V busqueda(Node current, K key) {
        if (current == null) return null;

        int comparacion = key.compareTo(current.key);
        if (comparacion == 0){
            return current.value;
        } 
        else if (comparacion < 0){
            return busqueda(current.left, key);
        } 
        else {
            return busqueda(current.right, key);
        } 
    }

    public void printOrdenado() {
        printOrdenados(root);
    }

    private void printOrdenados(Node current) {
        if (current != null) {
            printOrdenados(current.left);
            System.out.println(current.key + ": " + current.value);
            printOrdenados(current.right);
        }
    }
}
