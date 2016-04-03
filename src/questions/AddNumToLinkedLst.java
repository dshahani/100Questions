package questions;

import java.util.Stack;

public class AddNumToLinkedLst
{

	public static void main(String[] args)
	{
		LinkedList n1 = new LinkedList(1);
		LinkedList n2 = new LinkedList(9);
		LinkedList n3 = new LinkedList(9);
		LinkedList n4 = new LinkedList(9);
		LinkedList n5 = new LinkedList(9);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = null;

		int num = 9;

		Stack<LinkedList> stck = new Stack<LinkedList>();
		LinkedList cur = n1;
		while (cur.next != null)
		{
			stck.push(cur);
			cur = cur.next;
		}

		int carry = (cur.value + num) / 10;
		cur.value = (cur.value + num) % 10;
		while (!stck.isEmpty())
		{
			cur = stck.pop();
			cur.value = (cur.value + carry);
			carry = (cur.value) / 10;
			cur.value = (cur.value % 10);
		}

		while (n1 != null)
		{
			System.out.print(n1.value + "\t");
			n1 = n1.next;
		}
	}

}
