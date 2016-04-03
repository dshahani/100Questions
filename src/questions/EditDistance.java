package questions;

public class EditDistance
{

	public static void main(String[] args)
	{
		String s1 = "sunday", s2 = "saturday";
		int n = s1.length(), m = s2.length();
		int[][] opt = new int[n + 1][m + 1];
		for (int i = 0; i <= n; i++)
		{
			for (int j = 0; j <= m; j++)
			{
				if (i == 0)
				{
					opt[i][j] = j;
				} else if (j == 0)
				{
					opt[i][j] = i;
				}

				else if (s1.charAt(i - 1) == s2.charAt(j - 1))
				{
					opt[i][j] = opt[i - 1][j - 1];
				} else
				{
					opt[i][j] = 1 + Math.min(opt[i][j - 1], Math.min(opt[i - 1][j], opt[i - 1][j - 1]));
				}
			}
		}

		System.out.println(opt[n][m]);
	}

}
