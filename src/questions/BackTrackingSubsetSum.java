package questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BackTrackingSubsetSum
{

	public static void main(String[] args)
	{
		Integer[] arr = { 10, 15, 1, 3, -11, -7, -5, -4, -8, 9 };
		List<Integer> lst = new ArrayList<Integer>();
		lst = Arrays.asList(arr);
		Collections.sort(lst);
		allSubset(lst, new ArrayList<Integer>(), 0, 0, 0);

	}

	public static void allSubset(List<Integer> lst, List<Integer> res, int sum, int index, int currSum)
	{

		if (currSum == sum)
		{
			for (Integer t : res)
			{
				System.out.print(t + ",");
			}
			System.out.println();

		}

		if (index + 1 < lst.size())
		{
			for (int i = index; i < lst.size(); i++)
			{
				if (currSum + lst.get(i) <= sum)
				{
					res.add(lst.get(i));
					allSubset(lst, res, sum, i + 1, currSum + lst.get(i));
					res.remove(res.size() - 1);
				}
			}

		}

	}

}
