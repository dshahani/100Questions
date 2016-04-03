package questions;

import java.util.HashMap;
import java.util.Map;

public class LRUCache
{
	Map<Integer, LinkedList> lruMap = new HashMap<Integer, LinkedList>();
	int capacity;
	LinkedList head;
	LinkedList end;

	LRUCache(int capacity)
	{
		this.capacity = capacity;
	}

	public LinkedList get(int key)
	{
		if (lruMap.containsKey(key))
		{
			LinkedList node = lruMap.get(key);
			remove(node);
			setHead(node);
			return node;
		} else
		{
			return null;
		}
	}

	public void remove(LinkedList node)
	{
		if (node == null)
		{
			return;
		}

		if (node.prev != null)
		{
			node.prev.next = node.next;
		} else
		{
			head = node.next;
		}

		if (node.next != null)
		{
			node.next.prev = node.prev;
		} else
		{
			end = node.prev;
		}
	}

	public void setHead(LinkedList node)
	{
		node.next = head;
		node.prev = null;
		if (head != null)
		{
			head.prev = node;
		}
		head = node;

		if (end == null)
		{
			end = head;
		}
	}

	public void set(int key, int value)
	{
		if (lruMap.containsKey(key))
		{
			LinkedList old = lruMap.get(key);
			old.value = value;
			remove(old);
			setHead(old);
		} else
		{
			LinkedList newNode = new LinkedList(value);
			if (lruMap.size() > capacity)
			{
				lruMap.remove(end.key);
				remove(end);
			}
			setHead(newNode);
			lruMap.put(key, newNode);
		}

	}
}
