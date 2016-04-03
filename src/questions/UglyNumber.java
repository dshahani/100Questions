package questions;

/*
 * Ugly numbers are numbers whose only prime factors are 2, 3 or 5. The sequence
 * 1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, …
 * shows the first 11 ugly numbers. By convention, 1 is included.
 * Write a program to find and print the 150’th ugly number.
 */
public class UglyNumber
{
	public static void main(String[] args)
	{
		int n = 20;
		int i2 = 1, i3 = 1, i5 = 1;
		System.out.print("1 ");
		for (int i = 1; i < n; i++)
		{
			if (2 * i2 == 3 * i3)
			{
				System.out.print(3 * i3 + " ");
				i3++;
				i2++;
			} else if (5 * i5 == 3 * i3)
			{
				System.out.print(5 * i5 + " ");
				i5++;
				i3++;
			} else if (5 * i5 == 2 * i2)
			{
				System.out.print(5 * i5 + " ");
				i5++;
				i2++;
			} else if (2 * i2 < 3 * i3)
			{
				if (2 * i2 < 5 * i5)
				{
					System.out.print(2 * i2 + " ");
					i2++;
				} else if (2 * i2 > 5 * i5)
				{
					System.out.print(5 * i5 + " ");
					i5++;
				} else
				{
					System.out.print(5 * i5 + " ");
					i5++;
					i2++;
				}

			} else if (3 * i3 < 5 * i5)
			{
				System.out.print(3 * i3 + " ");
				i3++;
			} else if (5 * i5 < 3 * i3)
			{
				System.out.print(5 * i5 + " ");
				i5++;
			}
		}

	}
}
