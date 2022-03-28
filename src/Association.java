

public class Association<K,V>{

	protected K theKey;
	protected V theValue;
	
	public Association(K key, V value) {
		// pre: key is non-null
		// post: constructs a key-value pair
		
		theKey = key;
		theValue = value;
		
		
	}
	
	public V getValue() {
		// post: returns value from association
		
		return theValue;
		
	}
	public K getKey() {
		// post: returns key from association
		
		return theKey;
	}
	
	public V setValue(V value) {
		// post: sets association's value to value
		V oldValue = theValue;
		theValue = value;
		return oldValue;
		
	}
	
	
	
}
