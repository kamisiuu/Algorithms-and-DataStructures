package Trees;
import Trees.BinarySearchTree;
public class BinaryTree {

	BinarySearchTree root;

	BinarySearchTree treesearch(BinarySearchTree x, int key) {
		if (x == null || key == x.key) {
			return x;
		}

		if (key < x.key) {
			return treesearch(x.left, key);
		} else {
			return treesearch(x.right, key);
		}
	}

	public BinarySearchTree search(BinarySearchTree x, int key) {

		if (x == null || key == x.key)
			return x;
		if (key < x.key)
			return search(x.left, key);
		else
			return search(x.right, key);

	}

	public void insert(BinarySearchTree z) {
		BinarySearchTree y = null;
		BinarySearchTree x = root;

		while (x != null) {
			y = x;
			if (z.key < x.key)
				x = x.left;
			else
				x = x.right;
		}
		z.p = y;
		if (y == null)
			root = z;
		else if (z.key < y.key)
			y.left = z;
		else
			y.right = z;
	}

	public void trans(BinarySearchTree u, BinarySearchTree v) {
		if (u.p == null)
			root = v;
		else if (u == u.p.left)
			u.p.left = v;
		else
			u.p.right = v;
		if (v != null)
			v.p = u.p;
	}

	public BinarySearchTree min(BinarySearchTree x) {
		while (x.left != null)
			x = x.left;
		return x;
	}

	public void delete(BinarySearchTree z) {
		if (z.left == null)
			trans(z, z.right);
		else if (z.right == null)
			trans(z, z.left);
		else {
			BinarySearchTree y = min(z.right);
			if (y.p != z) {
				trans(y, y.right);
				y.right = z.right;
				z.right.p = y;
			}
			trans(z, y);
			y.left = z.left;
			y.left.p = y;
		}
	}

	public void inorder(BinarySearchTree x) {
		if (x != null) {
			System.out.print("( ");
			if (x.left != null) {
				inorder(x.left);
				System.out.print(" ");
			}

			System.out.print(x.key);
			if (x.right != null) {

				System.out.print(" ");
				inorder(x.right);

			}
			System.out.print(" )");
		}
		if(x == null){
			System.out.println("Ingen noder har blitt funnet, man kan ikke lage tret");
		}
	}
}