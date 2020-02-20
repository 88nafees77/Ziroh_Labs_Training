package sorting;

public class BinarySearch {
	public int binarySearch(int arr[], int l, int h, int key) {

		while (l < h) {
			int mid = l+h / 2;
			if (arr[mid+1] > key && arr[mid-1]<key) {
				return mid;
			}
			if (arr[mid] > key) {
				l = mid + 1;
			} else {
				h = mid;
			}
		}
		return -1;

	}
}
