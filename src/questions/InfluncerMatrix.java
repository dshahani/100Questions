package questions;

public class InfluncerMatrix
{

	public static void main(String[] args)
	{
		int[][] matrix = { { 0, 1, 1 }, { 0, 1, 1 }, { 1, 1, 0 } };
		boolean influncer = true;
		for (int i = 0; i < matrix.length; i++)
		{
			for (int j = 0; j < matrix[0].length; j++)
			{
				if (i != j && (matrix[i][j] == 0 || matrix[j][i] == 1))
				{
					influncer = false;
					continue;
				}
			}
			if (influncer)
			{
				System.out.println(i + " is a influncer.");
			}
			influncer = true;
		}

	}

}
