package Oblig4;


public class BinarySearchTree{
	public Node root;

	public BinarySearchTree(){
		this.root = null;
	}

	public void insert(String z){
		if(root == null){
			root = new Node(z);
			return;
		}
		Node current = root;

		while (current != null) {
			if (z.compareTo(current.word) < 0){
				if(current.left==null){
					current.left = new Node(z);
					return;
				}
				current = current.left;
			}
			else if (z.compareTo(current.word)> 0){
				if(current.right==null){
					current.right = new Node(z);
					return;
				}
				current = current.right;
			}
			else{
				current.counter++;
				return;
			}
		}
	}

	public void print(Node x) {
		
		if(x.left != null){
			print(x.left);
		}
		System.out.println(x.word + " - " + x.counter);

		if(x.right != null){
			print(x.right);		
		}
	}
}
