package questions;

public class PrimeFactors
{
	public static void main(String[] args)
	{
		int number = 60;

		while (number % 2 == 0)
		{
			System.out.print("2 \t");
			number = number / 2;
		}

		for (int i = 3; i < Math.sqrt(number); i = i + 2)
		{
			while (number % i == 0)
			{
				System.out.print(i + "\t");
				number = number / i;
			}
		}

		if (number > 2)
		{
			System.out.print(number);
		}
	}
}
