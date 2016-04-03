package questions;

import java.util.Stack;

public class NextSmaller
{
	static class Point
	{
		int x, nextIndex;

		Point(int x)
		{
			this.x = x;
			this.nextIndex = -1;
		}

	}

	static Point[] toPoint(int[] arr)
	{
		Point[] parr = new Point[arr.length];
		Point p;
		for (int i = 0; i < arr.length; i++)
		{
			p = new Point(arr[i]);
			parr[i] = p;
		}
		return parr;
	}

	public static void main(String[] args)
	{
		int[] arr = { 10, 20, 30, 50, 10, 70, 30 };
		Point[] parr = toPoint(arr);
		Stack<Integer> stck = new Stack<Integer>();
		stck.push(arr[0]);
		int next, peek;
		for (int i = 1; i < parr.length; i++)
		{
			next = arr[i];
			peek = stck.peek();
			if (next < peek)
			{
				while (!stck.isEmpty() && stck.peek() > next)
				{
					System.out.println(stck.pop() + " : " + i);
				}
			}
			stck.push(next);
		}

		while (!stck.isEmpty())
		{
			System.out.println(stck.pop() + " : " + arr.length);
		}
	}

}
