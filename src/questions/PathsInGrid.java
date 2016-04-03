package questions;

public class PathsInGrid
{
	static int tr = 2, tc = 1;

	public static void main(String[] arg)
	{
		int[][] matrix = { { 5, 1, 9 }, { 10, 11, 12 }, { 12, 15, 13 } };
		int row = matrix.length, col = matrix[0].length;
		int[][] opt = new int[row][col];
		boolean[][] visited = new boolean[row][col];

		for (int i = 0; i < row; i++)
		{
			for (int j = 0; j < col; j++)
			{
				opt[0][0] = 0;
			}
		}
		opt[0][0] = 1;

		updatePath(matrix, opt, visited, 0, 0);
		/*
		 * for (int i = 0; i < row; i++) { for (int j = 0; j < col; j++) { if
		 * (!visited[i][j]) { visited[i][j] = true; updatePath(matrix, opt, i,
		 * j); }
		 * 
		 * } }
		 */

		System.out.println(opt[tr][tc]);

		for (int i = 0; i < row; i++)
		{
			for (int j = 0; j < col; j++)
			{
				System.out.print(opt[i][j] + "\t");
			}
			System.out.println("");
		}
	}

	public static void updatePath(int[][] matrix, int[][] opt, boolean[][] visited, int r, int c)
	{
		if (r == tr && c == tc)
		{
			return;
		}
		int[] rowNmr = { -1, -1, -1, 0, 0, 1, 1, 1 };
		int[] colNmr = { -1, 0, 1, -1, 1, -1, 0, 1 };
		visited[r][c] = true;
		for (int i = 0; i < 8; i++)
		{
			if (isValid(matrix, r, c, r + rowNmr[i], c + colNmr[i]))
			{
				opt[r + rowNmr[i]][c + colNmr[i]] += 1;
				updatePath(matrix, opt, visited, r + rowNmr[i], c + colNmr[i]);
			}

		}

	}

	public static boolean isValid(int[][] matrix, int r, int c)
	{
		return (r < matrix.length && c < matrix[0].length);
	}

	public static boolean isValid(int[][] matrix, int r, int c, int nr, int nc)
	{
		return (r >= 0 && c >= 0 && nr >= 0 && nc >= 0 && nr < matrix.length && nc < matrix[0].length
				&& r < matrix.length && c < matrix[0].length && matrix[r][c] < matrix[nr][nc]);
	}
}
