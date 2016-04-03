package questions;

public class ReverseLinkedList
{

	public static void main(String[] args)
	{
		LinkedList n1 = new LinkedList(5);
		LinkedList n2 = new LinkedList(4);
		LinkedList n3 = new LinkedList(3);
		LinkedList n4 = new LinkedList(2);
		LinkedList n5 = new LinkedList(1);

		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = null;

		n5.prev = n4;
		n4.prev = n3;
		n3.prev = n2;
		n2.prev = n1;
		n1.prev = null;

		/*
		 * printLst(n1); LinkedList h1 = reverseLst(n1); printLst(h1);
		 */

		printDoublyLst(n1);
		n1 = reverseDoublyLst(n1);
		printDoublyLst(n1);
	}

	public static void printDoublyLst(LinkedList head)
	{
		LinkedList tmp = null;
		while (head != null)
		{
			System.out.print(head.value + "->");
			tmp = head;
			head = head.next;
		}
		head = tmp;
		while (head != null)
		{
			System.out.print(head.value + "->");
			head = head.prev;
		}
		System.out.println();
	}

	public static void printLst(LinkedList head)
	{
		while (head != null)
		{
			System.out.print(head.value + "->");
			head = head.next;
		}
		System.out.println();
	}

	public static LinkedList reverseLst(LinkedList head)
	{
		if (head == null)
		{
			return null;
		}

		LinkedList prev, current, next;
		prev = null;
		current = head;

		while (current != null)
		{
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		head = prev;
		return head;
	}

	/*
	 * public static LinkedList reverseLstV2(LinkedList head) { LinkedList p, q;
	 * p = head; q = p.next; p.next = null;
	 * 
	 * while (q != null) { q = p ^ q ^ q.next ^ (q.next = p) ^ (p = q); }
	 * 
	 * }
	 */

	public LinkedList Reverse(LinkedList list)
	{
		if (list == null)
			return null; // first question

		if (list.next == null)
			return list; // second question

		// third question - in Lisp this is easy, but we don't have cons
		// so we grab the second element (which will be the last after we
		// reverse it)

		LinkedList secondElem = list.next;

		// bug fix - need to unlink list from the rest or you will get a cycle
		list.next = null;

		// then we reverse everything from the second element on
		LinkedList reverseRest = Reverse(secondElem);

		// then we join the two lists
		secondElem.next = list;

		return reverseRest;
	}

	public static LinkedList reverseDoublyLst(LinkedList head)
	{
		if (head == null)
		{
			return null;
		}

		LinkedList current, tmp = null;
		current = head;

		while (current != null)
		{
			tmp = current.prev;
			current.prev = current.next;
			current.next = tmp;
			current = current.prev;
		}
		head = tmp.prev;
		return head;
	}

}
