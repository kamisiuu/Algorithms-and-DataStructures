package Trees;
import Trees.BinarySearchTree;

public class Main {

	public static void main(String[] args) {

		int[] A = { 5, 1,2,3,4,6,7,8,9 };
		int[] B = { 5,7,8,9 };

		BinaryTree tree = new BinaryTree();

		System.out.println("Noder før innseting i et tre: ");
		ArrayIO.printArray(A);
		System.out.println("\n" + "Binært tre:");

		for (int i = 0; i < A.length; i++) {
			BinarySearchTree nodes = new BinarySearchTree(A[i]);
			tree.insert(nodes);
		}

		tree.inorder(tree.root);
		System.out.println("\n" + "Root: " + tree.root + "\n");
		System.out.println("Noder som skal slettes:");
		ArrayIO.printArray(B);
		System.out.println("\n" + "Binært treet etter sletting:");

		for (int i = 0; i < B.length; i++) {
			BinarySearchTree node = tree.treesearch(tree.root, B[i]);
			if (node != null)
				tree.delete(node);
		}

		try {
			tree.inorder(tree.root);

		} catch (NullPointerException e) {
			System.out.println("Ingen noder funnet");

		}

		System.out.println("\n" + "Root: " + tree.root);

	}
}