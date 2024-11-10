package G_DivideConquer;

//approch: select a pivot element and place it at its correct position in the array.
import _Essentials.A_PrintArr;

public class A_QuickSort {

    public static void quickSort(int[] arr, int si, int ei) {
        if (si > ei)
            return;
        int pivot = arr[ei];
        int j = si;
        for (int i = si; i < ei; i++) {
            if (arr[i] < pivot) {
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
                j++;
            }
        }
        int temp = arr[ei];
        arr[ei] = arr[j];
        arr[j] = temp;
        quickSort(arr, si, j - 1);
        quickSort(arr, j + 1, ei);
    }

    public static void main(String[] args) {
        int arr[] = { 1, 4, 5, 3, 2, -1 };
        int si = 0;
        int ei = arr.length - 1;
        quickSort(arr, si, ei);
        A_PrintArr printArr = new A_PrintArr();
        printArr.print(arr);
    }
}
