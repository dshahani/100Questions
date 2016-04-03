package questions;

import java.util.Stack;

public class AddTwoLinkedList
{
	public static void main(String[] arg)
	{
		LinkedList n1 = new LinkedList(1);
		LinkedList n2 = new LinkedList(9);
		LinkedList n3 = new LinkedList(9);
		/*
		 * LinkedList n4 = new LinkedList(9); LinkedList n5 = new LinkedList(9);
		 */
		n1.next = n2;
		n2.next = n3;
		n3.next = null;
		/*
		 * n4.next = n5; n5.next = null;
		 */

		LinkedList r1 = new LinkedList(1);
		LinkedList r2 = new LinkedList(9);
		LinkedList r3 = new LinkedList(9);
		LinkedList r4 = new LinkedList(9);
		LinkedList r5 = new LinkedList(9);
		r1.next = r2;
		r2.next = r3;
		r3.next = r4;
		r4.next = r5;
		r5.next = null;

		int s1 = length(n1);
		int s2 = length(r1);
		LinkedList h1, h2;
		h1 = (s1 > s2 ? n1 : r1);
		h2 = (h1 == n1 ? r1 : n1);
		Stack<LinkedList[]> stck = new Stack<LinkedList[]>();
		LinkedList[] arr;
		if (s1 != s2)
		{
			int dif = Math.abs(s1 - s2);
			while (dif > 0)
			{
				arr = new LinkedList[2];
				arr[0] = h1;
				stck.push(arr);
				h1 = h1.next;
				dif--;
			}
		}

		while (h1.next != null && h2.next != null)

		{
			arr = new LinkedList[2];
			arr[0] = h1;
			arr[1] = h2;
			stck.push(arr);
			h1 = h1.next;
			h2 = h2.next;
		}

		int carry = (h1.value + h2.value) / 10;
		h1.value = (h1.value + h2.value) % 10;

		while (!stck.isEmpty())

		{
			arr = stck.pop();
			int a, b;
			a = (arr[0] == null ? 0 : arr[0].value);
			b = (arr[1] == null ? 0 : arr[1].value);
			arr[0].value = (a + b + carry);
			carry = arr[0].value / 10;
			arr[0].value = arr[0].value % 10;
		}

		LinkedList t = (s1 > s2 ? n1 : r1);
		while (t != null)

		{
			System.out.print(t.value + "\t");
			t = t.next;
		}

	}

	public static int length(LinkedList node)
	{
		int count = 0;
		while (node != null)
		{
			count++;
			node = node.next;
		}
		return count;
	}
}
