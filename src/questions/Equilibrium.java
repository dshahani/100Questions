package questions;

public class Equilibrium
{

	public static void main(String[] args)
	{
		int[] arr = { 1, 2, 3, 4, 2, 4, 4 };
		int currSum = 0, totalSum = 0;
		for (int i = 0; i < arr.length; i++)
		{
			totalSum += arr[i];
		}
		for (int i = 0; i < arr.length; i++)
		{
			currSum += arr[i];
			if (currSum == (totalSum - currSum))
			{
				System.out.println("index is " + i);
				break;
			}
		}

	}

}
