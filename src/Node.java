

public class Node<K extends Comparable<K>,V> extends ComparableAssociation<K,V>{

	
	K key;
	V data;

	
	Node<K,V> leftChild;
	Node<K,V> rightChild;
	
	
	public Node(K key, V data) {
		super(key, data);
		this.key = key;
		this.data = data;
		
	}
	
	public void printNode() {
		
		System.out.printf("		Palabra: %-15s Traducciones: %s\n", key, data); 
		
	}
	
}
