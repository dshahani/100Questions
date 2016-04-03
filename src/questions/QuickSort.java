package questions;

public class QuickSort
{
	public static void main(String[] arg)
	{
		int[] arr = { 10, 8, 1, 5, 7, 3, 4, 19 };
		quickSort(0, arr.length - 1, arr);
		for (int i = 0; i < arr.length; i++)
		{
			System.out.print(arr[i] + "\t");
		}

		System.out.println(findMedian(arr, 4, 0, arr.length - 1));
	}

	public static int findMedian(int[] arr, int k, int low, int high)
	{
		int p = partition(arr, low, high);

		if (k - 1 == p)
		{
			return arr[p];
		}

		if (k - 1 < p)
		{
			return findMedian(arr, k, low, p - 1);
		} else
		{
			return findMedian(arr, k, p + 1, high);
		}
	}

	public static void quickSort(int low, int high, int[] a)
	{
		if (low >= high)
		{
			return;
		}

		int p = partition(a, low, high);
		quickSort(low, p - 1, a);
		quickSort(p + 1, high, a);
	}

	public static int partition(int[] arr, int low, int high)
	{
		int pivot = arr[high], temp;
		int i = low - 1;
		for (int j = low; j < high; j++)
		{
			if (arr[j] < pivot)
			{
				i++;
				temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		temp = arr[high];
		arr[high] = arr[i + 1];
		arr[i + 1] = temp;
		return i + 1;
	}
}
