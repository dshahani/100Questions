package questions;

public class CheckFib
{
	boolean isPerfectSquare(int x)
	{
		int s = (int) Math.sqrt(x);
		return (s * s == x);
	}

	// Returns true if n is a Fibinacci Number, else false
	boolean isFibonacci(int n)
	{
		// n is Fibinacci if one of 5*n*n + 4 or 5*n*n - 4 or both
		// is a perferct square
		return isPerfectSquare(5 * n * n + 4) || isPerfectSquare(5 * n * n - 4);
	}

}
