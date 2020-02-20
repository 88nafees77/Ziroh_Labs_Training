package sorting;

public class MainClass {
	public static void main(String[] args) {
		CountingSort sort = new CountingSort();
		int arr[] = { 1, 2, 4, 6, 8, 7 };
		int ar[] = sort.countingSort(arr);

		for (int i = 0; i < ar.length; i++) {
			System.out.print(ar[i] + " ");
		}

		//BinarySearch binarySearch = new BinarySearch();
		//int x = binarySearch.binarySearch(arr, 0, arr.length, 3);
		//System.out.println(x);
	}
}
