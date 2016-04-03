package questions;

import java.util.Random;

public class CovertIntToString
{

	public static final String[] units = { "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
			"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen",
			"nineteen" };

	public static final String[] tens = { "", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty",
			"ninety" };

	public static String convert(int n)
	{

		if (n < 0)
		{
			return "minus" + convert(-n);
		}
		if (n < 20)
		{
			return units[n];
		}
		if (n < 100)
		{
			return tens[n / 10] + ((n % 10 != 0 ? " " : "")) + units[n % 10];
		}
		if (n < 1000)
		{
			return units[n / 100] + "hundred" + ((n % 100 != 0) ? " " : "") + convert(n % 100);
		}
		if (n < 10000)
		{
			return units[n / 1000] + "thousand" + ((n % 1000 != 0) ? " " : "") + convert(n % 1000);
		}
		return "";
	}

	public static void main(String[] args)
	{
		final Random generator = new Random();
		int n;
		for (int i = 0; i < 20; i++)
		{
			n = generator.nextInt(Integer.MAX_VALUE);
			System.out.print(convert(n));
		}
		n = 1000;
		System.out.println(n + "=" + convert(n));

		n = 2946;
		System.out.println(n + "=" + convert(n));

	}

}
