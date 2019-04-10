package Queue;
import Oblig1.QueueADT;

public class QueueQ<T> implements QueueADT<T> {
	
	public T[] queue;
	private int head;
	private int tail;
	private int count;
	//konstruktør som setter ved oppretting head og tail til å være 0 og initierer kapasiteten på køen
	@SuppressWarnings("unchecked")
	public QueueQ(int InitialCapacity){
		head=0;
		tail=0;
		count=0;
		queue=(T[])(new Object[InitialCapacity]);
		
	}
	@Override
	public void enqueue(T element) {
		if(count!=queue.length&&tail==queue.length-1){
			tail=0;
			queue[tail]=element;
			count++;
		}
		else if(count!=queue.length){
			queue[tail]=element;
			tail++;
			count++;
		}
	}

	@Override
	public T dequeue() {
		
		if(!isEmpty()){
		T element=queue[head];
		head++;
		count--;
			if(isEmpty()){
			head=0;
			tail=0;
			}
		return element;	
		}
		else {
		return null;
		}}

	@Override
	public T first() {
		T element=queue[head];
		return element;
	}

	@Override
	public boolean isEmpty() {
		if(size()==0){
			return true;
		}
		return false;
	}

	@Override
	public int size() {
		return count;
	}

}
