package Queue;

public interface QueueADT<T> {

	// legge til et element bakerst i køen
	public void enqueue(T element);
	
	// ta ut første element i køen
	public T dequeue();
	
	//se på første element i køen
	public T first();
	
	// Avgjøre om køen er tom
	public boolean isEmpty();
	
	// antall elementer som er lagret i køen
	public int size();
}
