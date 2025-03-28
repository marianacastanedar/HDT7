import org.junit.Test;
import org.junit.Assert;

public class MainTest {

    @Test
    public void testInsertAndSearch() {
        BinaryTree<String, String> arbol = new BinaryTree<>();

        
        arbol.insert("b001", "Producto B");
        arbol.insert("a001", "Producto A");
        arbol.insert("c001", "Producto C");

        
        Assert.assertEquals("Producto A", arbol.search("a001"));
        Assert.assertEquals("Producto B", arbol.search("b001"));
        Assert.assertEquals("Producto C", arbol.search("c001"));

        
        Assert.assertNull(arbol.search("z999"));
    }
}


