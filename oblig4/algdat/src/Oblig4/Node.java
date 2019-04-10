package Oblig4;

public class Node{
	String word;
	Node left;
	Node right;	
	int counter;
	
	
	public Node(String word) {
		this.word = word;
		left = null;
		right = null;
		counter = 1;
	}
}
