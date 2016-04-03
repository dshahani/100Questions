package questions;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BuildTree
{

	// Child Parent IsLeft
	// 15 20 true
	// 19 80 true
	// 17 20 false
	// 16 80 false
	// 80 50 false
	// 50 null false
	// 20 50 true

	// You should return the following tree:
	// 50
	// / \
	// 20 80
	// / \ / \
	// 15 17 19 16

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

	public class Relation
	{
		public Integer parent;
		public Integer child;
		public boolean isLeft;
	}

	public class Node
	{
		public Integer id;
		public Node left;
		public Node right;
	}

	public Node buildTree(List<Relation> data)
	{
		Node root = findRoot(data, 0);
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		Node curr, node;
		while (!queue.isEmpty())
		{
			curr = queue.poll();
			int parent = curr.id;
			for (Relation rel : data)
			{
				if (rel.parent == parent)
				{
					node = new Node();
					node.id = rel.child;
					queue.add(node);
					if (rel.isLeft)
					{
						curr.left = node;
					} else
					{
						curr.right = node;
					}
				}
			}
		}
		return root;
	}

	public Node findRoot(List<Relation> data, int index)
	{
		Node node;
		if (data.get(index) != null && data.get(index).parent == null)
		{
			node = new Node();
			node.id = data.get(index).child;
			return node;
		}
		return findRoot(data, index + 1);
	}

}
