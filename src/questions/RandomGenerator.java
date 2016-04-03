package questions;

import java.util.Random;

/*
 * Generate random number generator (mod 7) using (mod 5).
 */

public class RandomGenerator
{
	public static void main(String[] args)
	{
		Random rand = new Random();
		int a, b, r;

		do

		{
			a = rand.nextInt(4); // uniformly at random from 0 to wi4
			b = rand.nextInt(4); // uniformly at random from 0 to 4
			r = 5 * a + b; // uniformly at random from 0 to 24
		} while (r >= 21);
		// in this event, we have to roll again
		// postcondition of loop: we have a number uniformly at random between 0
		// and 20

		System.out.println((r % 7) + 1);

		// there are 3 numbers in [0, 20] for each possible return value
		// so each has equal probability.
	}
}
