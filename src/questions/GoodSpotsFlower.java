package questions;

import java.util.List;

public class GoodSpotsFlower
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

	public boolean canPlaceFlowers(List<Boolean> flowerbed, int numberToPlace)
	{

		// Implementation here

		// list size 0
		int size = flowerbed.size();

		if (size == 0 || size < numberToPlace)
		{
			return false;
		}

		if (numberToPlace == 0)
		{
			return true;
		}

		// find a 0, look at elemenet on left and right, increment
		// if the 0 is at the beginning or end, only need neighbor to be 0
		int goodSpots = 0;

		for (int i = 0; i < size; i++)
		{
			Boolean prev = false;
			Boolean next = false;
			if (flowerbed.get(i) == false)
			{
				if (i > 0)
				{
					prev = flowerbed.get(i - 1);
					if (prev != false)
					{
						break;
					}
				}
				if (i < size - 1)
				{
					next = flowerbed.get(i + 1);
					if (next != false)
					{
						break;
					}
				}
				flowerbed.set(i, true);
				goodSpots++;
				if (goodSpots == numberToPlace)
				{
					return true;
				}

			}

		}

		return false;

	}

}
