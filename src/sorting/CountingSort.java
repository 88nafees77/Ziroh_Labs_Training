package sorting;

public class CountingSort {
	public int[] countingSort(int arr[]) {
		int C[] = new int[10];
		int B[] = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			C[arr[i]]++;
		}
		for (int i = 1; i < 10; i++) {
			C[i] = C[i] + C[i - 1];
		}
		for (int i = 0; i < arr.length; i++) {
			B[C[arr[i]]-1] = arr[i];
			C[arr[i]]--;
		} 

		return B;

	}
}
