package sorting;

public class InsertionSort {
	public int[] insertSort(int arr[]) {
		for (int j = 1; j < arr.length; j++) {
			int tmp = arr[j];
			int i = j - 1;
			while (i >= 0 && tmp < arr[i]) {
				arr[i + 1] = arr[i];
				i = i - 1;
			}
			arr[i + 1] = tmp;
		}
		return arr;
	}
}
