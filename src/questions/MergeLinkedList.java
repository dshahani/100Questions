package questions;

public class MergeLinkedList
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
		n5.next = null;

		LinkedList l1 = new LinkedList(2);
		LinkedList l2 = new LinkedList(4);
		LinkedList l3 = new LinkedList(5);
		LinkedList l4 = new LinkedList(8);
		LinkedList l5 = new LinkedList(9);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;

		LinkedList head = n1, head2 = l1, sortedHead = null;

		while (head != null && head2 != null)
		{
			if (head.value > head2.value)
			{
				if (sortedHead == null)
				{
					sortedHead = head2;
				} else
				{
					sortedHead.next = head2;
					sortedHead = sortedHead.next;
				}
				head2 = head2.next;
			} else
			{
				if (sortedHead == null)
				{
					sortedHead = head;
				} else
				{
					sortedHead.next = head;
					sortedHead = sortedHead.next;
				}
				head = head.next;
			}
		}

		while (head != null)
		{
			sortedHead.next = head;
			head = head.next;
			sortedHead = sortedHead.next;
		}

		while (head2 != null)
		{
			sortedHead.next = head2;
			head2 = head2.next;
			sortedHead = sortedHead.next;
		}

		LinkedList node = (n1.value > n2.value ? n2 : n1);

		ReverseLinkedList.printLst(node);
	}

}
