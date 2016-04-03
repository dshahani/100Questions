package questions;

public class GenerateNumberSeq
{

	public static void main(String[] args)
	{
		System.out.println(numSeq(2, 2, 2, 2));
	}

	public static int numSeq(int ones, int twos, int threes, int fours)
	{
		return numSeqHelper(ones, twos, threes, fours, 0);
	}

	public static int numSeqHelper(int ones, int twos, int threes, int fours, int lastDigit)
	{
		if (ones == 0 && twos == 0 && threes == 0 && fours == 0)
		{
			return 1;
		}

		int onesSeq = 0;
		int twosSeq = 0;
		int threesSeq = 0;
		int foursSeq = 0;

		if (lastDigit != 1 && ones != 0)
			onesSeq += numSeqHelper(ones - 1, twos, threes, fours, 1);
		if (lastDigit != 2 && twos != 0)
			onesSeq += numSeqHelper(ones, twos - 1, threes, fours, 2);
		if (lastDigit != 3 && threes != 0)
			onesSeq += numSeqHelper(ones, twos, threes - 1, fours, 3);
		if (lastDigit != 4 && fours != 0)
			onesSeq += numSeqHelper(ones, twos, threes, fours - 1, 4);

		return onesSeq + twosSeq + threesSeq + foursSeq;
	}

}
