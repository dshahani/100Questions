package questions;

import java.util.Stack;

public class NextGreater
{

	public static void main(String[] args)
	{
		int[] arr = { 13, 7, 6, 12 };
		Stack<Integer> stck = new Stack<Integer>();
		stck.push(arr[0]);
		int next, peek;
		for (int i = 1; i < arr.length; i++)
		{
			next = arr[i];
			peek = stck.peek();
			if (next > peek)
			{
				while (!stck.isEmpty() && stck.peek() < next)
				{
					System.out.println(stck.pop() + " : " + next);
				}
			}
			stck.push(next);
		}

		while (!stck.isEmpty())
		{
			System.out.println(stck.pop() + " : -1");
		}
	}

}
