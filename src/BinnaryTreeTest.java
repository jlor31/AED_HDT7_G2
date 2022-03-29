import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;

class BinnaryTreeTest {

	@Test
	void testAddNode() {
		BinnaryTree<String, ArrayList<String>> arbol = new BinnaryTree<String, ArrayList<String>>();
		ArrayList<String> palabras = new ArrayList<String>();
		palabras.add("English");
		palabras.add("Ingles");
		palabras.add("Anglais");
		
		Node<String, ArrayList<String>>nodeOriginal = new Node<String, ArrayList<String>>("English", palabras);
		
		arbol.addNode("English", palabras);
		Node<String, ArrayList<String>>nodeTest = arbol.getNode("English");
		
		// Comnprueba que el nodo fue agregado correctamente
		assertEquals(nodeTest.key,nodeOriginal.key);
		assertEquals(nodeTest.data, nodeOriginal.data);
	}


	@Test
	void testGetNode() {
		BinnaryTree<String, ArrayList<String>> arbol = new BinnaryTree<String, ArrayList<String>>();
		ArrayList<String> palabras1 = new ArrayList<String>();
		palabras1.add("English");
		palabras1.add("Ingles");
		palabras1.add("Anglais");
		
		
		
		
		ArrayList<String> palabras = new ArrayList<String>();
		palabras.add("Spanish");
		palabras.add("Español");
		palabras.add("Espagnol");
		
		Node<String, ArrayList<String>>nodeOriginal = new Node<String, ArrayList<String>>("Spanish", palabras);
		
		arbol.addNode("Spanish", palabras);
		Node<String, ArrayList<String>>nodeTest = arbol.getNode("Spanish");
		
		// Comnprueba que el nodo fue agregado correctamente
		assertEquals(nodeTest.key,nodeOriginal.key);
		assertEquals(nodeTest.data, nodeOriginal.data);
	}

}
