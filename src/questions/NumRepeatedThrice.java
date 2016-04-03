package questions;

public class NumRepeatedThrice
{

	public static void main(String[] args)
	{
		int[] arr = { 3, 1, 6, 2, 1, 2, 1, 2, 3, 3 };
		int ones = 0, twos = 0, cmbBits;
		for (int i = 0; i < arr.length; i++)
		{
			twos = twos | (ones & arr[i]);
			ones = ones ^ arr[i];
			cmbBits = ~(ones & twos);
			ones = ones & cmbBits;
			twos = twos & cmbBits;
		}

		System.out.println("Number is " + (ones));

	}

}
