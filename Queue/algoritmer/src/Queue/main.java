package Queue;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

import Oblig1.CircularArrayQueue;

public class main {
	//public static QueueKO<Integer>LandingQueue=new QueueKO<Integer>(6);
	//public static CircularArrayQueue<Integer> LandingQueue=new CircularArrayQueue<Integer>(3);
	public static QueueQ<Integer>Q1=new QueueQ<Integer>(3);
	public static int [] Flyene ={100,101,102};

	public static void main(String[]args){
		
		Q1.enqueue(10);
		Q1.enqueue(33);
		Q1.enqueue(33);
		Q1.enqueue(33);
		Q1.dequeue();
	
		Q1.dequeue();
		Q1.dequeue();
		Q1.enqueue(3);

		System.out.println(Q1.size());
		System.out.println(Q1.first());
		System.out.println(Q1.isEmpty());


}


	
}

