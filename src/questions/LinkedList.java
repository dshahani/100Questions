package questions;

public class LinkedList
{
	int value;
	int key;
	LinkedList next;
	LinkedList prev;

	LinkedList(int val)
	{
		this.value = val;
	}

	LinkedList(int val, LinkedList next)
	{
		this.value = val;
		this.next = next;
	}

	LinkedList(int val, LinkedList next, LinkedList prev)
	{
		this.value = val;
		this.next = next;
		this.prev = prev;
	}
}
