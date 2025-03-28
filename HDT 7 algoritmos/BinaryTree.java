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
        root = insertRecursive(root, key, value);
    }

    private Node insertRecursive(Node current, K key, V value) {
        if (current == null) return new Node(key, value);

        int cmp = key.compareTo(current.key);
        if (cmp < 0) {
            current.left = insertRecursive(current.left, key, value);
        } else if (cmp > 0) {
            current.right = insertRecursive(current.right, key, value);
        } else {
            current.value = value; // actualiza si ya existe
        }

        return current;
    }

    // Buscar por clave
    public V search(K key) {
        return searchRecursive(root, key);
    }

    private V searchRecursive(Node current, K key) {
        if (current == null) return null;

        int cmp = key.compareTo(current.key);
        if (cmp == 0) return current.value;
        else if (cmp < 0) return searchRecursive(current.left, key);
        else return searchRecursive(current.right, key);
    }

    // Mostrar todos (inorden)
    public void printInOrder() {
        printInOrderRecursive(root);
    }

    private void printInOrderRecursive(Node current) {
        if (current != null) {
            printInOrderRecursive(current.left);
            System.out.println(current.key + ": " + current.value);
            printInOrderRecursive(current.right);
        }
    }
}
