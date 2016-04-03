package questions;

import tree.Node;

public class DeleteNodeBST
{

	public static void main(String[] args)
	{
		Node root = new Node(6);
		Node a = new Node(3);
		Node b = new Node(9);
		Node c = new Node(1);
		Node d = new Node(4);
		Node e = new Node(5);
		Node f = new Node(7);
		Node g = new Node(10);
		root.left = a;
		root.right = b;
		a.parent = root;
		b.parent = root;

		a.left = c;
		a.right = d;
		c.parent = a;
		d.parent = a;

		d.right = e;
		e.parent = d;

		b.left = f;
		b.right = g;
		f.parent = b;
		g.parent = b;

		delete(root, 10);
	}

	public static Node delete(Node root, int key)
	{
		if (root == null)
		{
			return null;
		}

		if (root.value < key)
		{
			root.right = delete(root.right, key);
		} else if (root.value > key)
		{
			root.left = delete(root.left, key);
		} else
		{
			if (root.left == null)
			{
				return root.right;
			} else if (root.right == null)
			{
				return root.left;
			} else
			{
				root.value = minValue(root.right);
				root.right = delete(root.right, root.value);
			}
		}
		return root;
	}

	public static int minValue(Node root)
	{
		int min = root.value;
		while (root.left != null)
		{
			min = root.left.value;
			root = root.left;
		}
		return min;
	}

}
