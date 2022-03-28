import java.util.ArrayList;


/* Idea para la implementaciondel arbol obtenida del canal YT: 
 * Derek Banas en el video siguiente URL: https://www.youtube.com/watch?v=M6lYob8STMI
 * 
 * 	Se adapto el codigo para que sea generico y que funcione con la implementacion de
 *  ComparableAssociation, encontrada en el libro de texto del curso: "Java Structures" 
 *  del autor Duane A. Bailey y que tambien se encontraba en los recursos del curso en Canvas
 *  en el modulo "Arboles Binarios"
*/

public class BinnaryTree<K extends Comparable<K>,V> {
	
	 
	
	Node<K,V> root;
	
	public void addNode(K key, V data) {  //metodo para agregar nodos PROBAR CON JUNIT
		
		Node<K,V> newNode = new Node<K,V>(key, data);
		
		
		if (root == null) {
			
			root = newNode;
			
		}else {
			
			Node<K,V> focusNode = root;
			
			Node<K,V> parent;
			
			while(true) {
				
				parent = focusNode;
				
				if(newNode.compareTo(parent) < 0) {
					
					focusNode = focusNode.leftChild;
					
					if(focusNode == null) {
						
						parent.leftChild = newNode;
						return;
						
					}
					
					
					
				}else {
					
					focusNode = focusNode.rightChild;
					
					if (focusNode == null) {
						
						parent.rightChild = newNode;
						return;
					}
					
					
				}
				
				
				
			}
			
		}
		
	}
	
	public void inOrderTraverseTree(Node<String, ArrayList<String>> focusNode) { // metodo apra atravesar el arbol en inOrder 
		
		if(focusNode != null) {
			
			inOrderTraverseTree(focusNode.leftChild);
			
			focusNode.printNode();
			
			inOrderTraverseTree(focusNode.rightChild);
			
		}
		
	}
	
	public Node<K,V> getNode(K key){ // metodo para buscar y encontrar un nodo particular PROBAR CON JUNIT
		
		Node<K,V> focusNode = root;
		
		while(focusNode.key.compareTo(key) != 0) {
			
			if(key.compareTo(focusNode.key) < 0) {
				
				focusNode = focusNode.leftChild;
				
			} else {
				
				focusNode = focusNode.rightChild;
				
			}
			
			if (focusNode == null) {
				
				return null;
				
			}
			
			
		}
		
		return focusNode;
	}
	
	

}
