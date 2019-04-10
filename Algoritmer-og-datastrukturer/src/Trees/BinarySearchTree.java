package Trees;

public class BinarySearchTree {
	
	BinarySearchTree left;
	BinarySearchTree right;
	BinarySearchTree p;
	int key;
	
	public BinarySearchTree(int key) {
		this.key=key;
	}
	public String toString() {
		return ("" + key);
	}	
}
