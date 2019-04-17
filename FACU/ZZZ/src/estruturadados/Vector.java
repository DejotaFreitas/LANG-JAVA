package estruturadados;

public interface Vector {	
	
	void add(Object elemento);
	Object remove();
	Object get(int index);		
	boolean isEmpty();
	int size();
	void clean();
	
}
