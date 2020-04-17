package section009;

public class Tree {
	enum Order {
		PreOrder,
		InOrder,
		PostOrder
	}

	Node root;

	protected Node insert(Node node) {
		Node parent = null;
		Node child = root;

		while (child != null) {
			parent = child;
			if (node.key < child.key) child =child.left;
			else child = child.right;
		}
		node.parent = child;

		if (parent == null) {
			root = node;
		} else if (node.key < parent.key) {
			parent.left = node;
		} else {
			parent.right = node;
		}

		return node;
	}

	protected void print(Order order) {
		switch (order) {
			case PreOrder:
				walkPreOrder(root);
				break;
			case InOrder:
				walkInOrder(root);
				break;
			case PostOrder:
				walkPostOrder(root);
				break;
		}
		System.out.println();
	}

	private void walkPreOrder(Node node) {
		if (node == null) return;
		System.out.print(" " + node.key);
		walkPreOrder(node.left);
		walkPreOrder(node.right);
	}

	private void walkInOrder(Node node) {
		if (node == null) return;
		walkInOrder(node.left);
		System.out.print(" " + node.key);
		walkInOrder(node.right);
	}

	private void walkPostOrder(Node node) {
		if (node == null) return;
		walkPostOrder(node.left);
		walkPostOrder(node.right);
		System.out.print(" " + node.key);
	}
}
