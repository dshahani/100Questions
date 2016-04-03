package questions;

public class QuickSortLinkedList
{
	public static void main(String[] arg)
	{
		LinkedList n1 = new LinkedList(10);
		LinkedList n2 = new LinkedList(3);
		LinkedList n3 = new LinkedList(50);
		LinkedList n4 = new LinkedList(7);
		LinkedList n5 = new LinkedList(1);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = null;
		LinkedList end = tail(n1);
		quickSort(n1, end);

		while (n1 != null)
		{
			System.out.print(n1.value + "\t");
			n1 = n1.next;
		}
	}

	public static void quickSort(LinkedList head, LinkedList tail)
	{
		if (head != null && head != tail && head.next != tail && tail != null)
		{
			LinkedList p = partition(head, tail);
			quickSort(head, p);
			if (p == null)
			{
				p = head;
			}
			quickSort(p.next.next, tail);
		}

	}

	public static LinkedList tail(LinkedList head)
	{
		while (head.next != null)
		{
			head = head.next;
		}
		return head;
	}

	public static LinkedList partition(LinkedList low, LinkedList high)
	{
		int x = high.value;
		LinkedList i = null, prev = null;
		for (LinkedList j = low; j != high; j = j.next)
		{
			if (j.value < x)
			{
				prev = i;
				if (i == null)
				{
					i = low;
				} else
				{
					i = i.next;
				}
				swap(i, j);
			}
		}
		i = (i == null ? low : i.next);
		swap(i, high);
		return prev;
	}

	public static void swap(LinkedList node1, LinkedList node2)
	{
		if (node1 != null && node2 != null)
		{
			int t = node1.value;
			node1.value = node2.value;
			node2.value = t;
		}
	}
}
