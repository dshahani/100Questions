package questions;

public class AdjacentMax
{

	public static void main(String[] args)
	{
		int[] arr = { 7, 6, 10, 40, 50, 35 };

		int[] opt = new int[arr.length];

		opt[0] = arr[0];
		opt[1] = Math.max(arr[0], arr[1]);
		for (int i = 2; i < arr.length; i++)
		{
			opt[i] = Math.max(opt[i - 2] + arr[i], opt[i - 1]);
		}

		for (int i = 0; i < arr.length; i++)
		{
			System.out.print(opt[i] + "\t");
		}

		int prev, gpre;
		gpre = arr[0];
		prev = Math.max(arr[0], arr[1]);

		for (int i = 2; i < arr.length; i++)
		{
			opt[i] = Math.max(gpre + arr[i], prev);
			gpre = prev;
			prev = opt[i];
		}
		System.out.println("");
		for (int i = 0; i < arr.length; i++)
		{
			System.out.print(opt[i] + "\t");
		}
	}

}
