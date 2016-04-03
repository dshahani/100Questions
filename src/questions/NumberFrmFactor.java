package questions;

/*
 * Find number smallest number K , if exists, such that product of its digits is N. 
 * Eg: N = 6, smallest number is k=16(1*6=6) and not k=23(2*3=6).
 */

public class NumberFrmFactor
{
	public static void main(String[] arg)
	{
		System.out.println(getnumber(90));
	}

	public static int getnumber(int n)
	{
		int i = 9;
		int num = 0;
		int pow = 1;

		if (n < 10)
		{
			return n + 10;
		}

		while (i > 0)
		{
			while (n % i == 0 && i > 1)
			{
				num = i * pow + num;
				pow = pow * 10;
				n = n / i;
			}
			i--;
		}
		if (n != 1)
		{
			return -1;
		} else if (num < 10)
		{
			num = 1 * pow + num;
			return num;
		} else
		{
			return num;
		}
	}

}
