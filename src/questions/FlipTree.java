package questions;

import java.util.ArrayList;

public class FlipTree
{

	// Given a binary tree where all the right nodes are leaf nodes, flip it
	// upside down and turn it into a tree with left leaf nodes.

	// Keep in mind: ALL RIGHT NODES IN ORIGINAL TREE ARE LEAF NODE.

	public static void main(String[] args)
	{
		Node root = new Node(1);
		Node n1 = new Node(2);
		Node n2 = new Node(3);
		root.left = n1;
		root.right = n2;
		Node n3 = new Node(4);
		Node n4 = new Node(5);
		n1.left = n3;
		n1.right = n4;
		Node n5 = new Node(6);
		Node n6 = new Node(7);
		n3.left = n5;
		n3.right = n6;
		// printBTree(root);
		printBTree(FlipTree(root));

	}

	public static void printBTree(Node root)
	{
		ArrayList<Node> prnt = new ArrayList<Node>();
		ArrayList<Node> lst = new ArrayList<Node>();
		lst.add(root);
		System.out.println(root.data);
		while (!lst.isEmpty())
		{
			prnt = lst;
			lst = new ArrayList<Node>();
			for (Node node : prnt)
			{
				System.out.print(node.left != null ? node.left.data + "   " : 0 + "   ");
				System.out.print(node.right != null ? node.right.data + "   " : 0 + "   ");
				if (node.left != null)
				{
					lst.add(node.left);
				}
				if (node.right != null)
				{
					lst.add(node.right);
				}

			}
			System.out.println("");
		}
	}

	public static class Node
	{
		Node left;
		Node right;
		int data;

		Node(int data)
		{
			this.data = data;
		}
	}

	static Node FlipTree(Node root)
	{
		if (root == null)
			return null;

		// Working base condition
		if (root.left == null && root.right == null)
		{
			return root;
		}

		Node newRoot = FlipTree(root.left);

		root.left.left = root.right;
		root.left.right = root;
		root.left = null;
		root.right = null;

		return newRoot;
	}

}
