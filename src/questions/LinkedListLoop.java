package questions;

public class LinkedListLoop
{

	public static void main(String[] args)
	{
		LinkedList n1 = new LinkedList(1);
		LinkedList n2 = new LinkedList(3);
		LinkedList n3 = new LinkedList(5);
		LinkedList n4 = new LinkedList(7);
		LinkedList n5 = new LinkedList(10);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n3;

		LinkedList loop = detectLoop(n1);
		System.out.println(loop.value);
	}

	public static LinkedList detectLoop(LinkedList head)
	{
		LinkedList slow = head, fast = head;

		do
		{
			slow = slow.next;
			fast = fast.next.next;
		} while (slow != fast);

		if (slow == head)
		{
			return slow;
		} else
		{
			slow = head;
			while (slow != fast)
			{
				slow = slow.next;
				fast = fast.next;
			}
			return slow;
		}
	}

}
