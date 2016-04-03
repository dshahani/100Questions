package questions;

public class InterLeavedString
{
	static boolean isInterleaved(String A, String B, String C)
	{
		// Find lengths of the two strings
		int M = A.length(), N = B.length();

		// Let us create a 2D table to store solutions of
		// subproblems. C[i][j] will be true if C[0..i+j-1]
		// is an interleaving of A[0..i-1] and B[0..j-1].
		boolean IL[][] = new boolean[M + 1][N + 1];

		// C can be an interleaving of A and B only of sum
		// of lengths of A & B is equal to length of C.
		if ((M + N) != C.length())
			return false;

		for (int i = 0; i <= M; ++i)
		{
			// two empty strings have an empty string
			// as interleaving
			if (i == 0)
				IL[i][0] = true;
			// B is empty
			else if (A.charAt(i - 1) == C.charAt(i - 1))
				IL[i][0] = IL[i - 1][0];
		}
		for (int j = 0; j <= N; ++j)
		{
			if (j == 0)
				IL[0][j] = true;
			// A is empty
			else if (B.charAt(j - 1) == C.charAt(j - 1))
				IL[0][j] = IL[0][j - 1];
		}

		// Process all characters of A and B
		for (int i = 1; i <= M; ++i)
		{
			for (int j = 1; j <= N; ++j)
			{
				// two empty strings have an empty string
				// as interleaving

				// Current character of C matches with that of both A and B
				if (A.charAt(i - 1) == C.charAt(i + j - 1) && B.charAt(j - 1) == C.charAt(i + j - 1))
					IL[i][j] = (IL[i - 1][j] || IL[i][j - 1]);
				// Current character of C matches with current character of A,
				// but doesn't match with current character of B
				else if (A.charAt(i - 1) == C.charAt(i + j - 1) && B.charAt(j - 1) != C.charAt(i + j - 1))
					IL[i][j] = IL[i - 1][j];

				// Current character of C matches with current character of B,
				// but doesn't match with current character of A
				else if (A.charAt(i - 1) != C.charAt(i + j - 1) && B.charAt(j - 1) == C.charAt(i + j - 1))
					IL[i][j] = IL[i][j - 1];

			}
		}

		return IL[M][N];
	}

	static boolean interRec(char[] A, int a, char[] B, int b, char[] C, int c)
	{
		if (a == A.length - 1 && b == B.length && c == C.length - 1)
		{
			return true;
		}

		if (c == C.length - 1)
		{
			return false;
		}

		if (a < A.length - 1 && A[a] == C[c])
		{
			return interRec(A, a + 1, B, b, C, c + 1);
		} else if (b < B.length && B[b] == C[c])
		{
			return interRec(A, a, B, b + 1, C, c + 1);
		} else
		{
			return false;
		}

	}

	public static void main(String[] arg)
	{
		System.out.println(interRec("XXX".toCharArray(), 0, "XxXX".toCharArray(), 0, "XxXXXXX".toCharArray(), 0));
		System.out.println(isInterleaved("XXX", "XxXX", "XxXXXXX"));

	}
}
