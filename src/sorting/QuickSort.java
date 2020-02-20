/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorting;

/**
 *
 * @author nafees
 */
public class QuickSort {

    public void quickSort(int arr[], int low, int high) {
        if (low < high) {
            int pivot = partition(arr, low, high);
            quickSort(arr, low + 1, high);
            quickSort(arr, low, high - 1);

        }
    }

    public int partition(int arr[], int low, int high) {
        int pValue = arr[high];
        int i = low - 1;
        int j = 0;
        for (j = low; j < high - 1; j++) {
            if (arr[j] < pValue) {
                i = i + 1;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    public static void main(String[] args) {
        QuickSort qs = new QuickSort();
        int arr[] = {4, 2, 5, 7, 8};
        qs.quickSort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
