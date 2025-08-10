package G_DivideConquer;

import _Ess.PrintArr;

public class A_QuickSort {

    public static void quickSort(int[] arr, int si, int ei) {
        // base case (write this after you have written the recursive calls, then it will be easy )
        if (si >= ei)
            return;
        // logic part
        int mid = (si + ei) / 2;
        int pivot = arr[mid];// selecting middle element will be better for time complexity (nlogn)
        int j = si;// j will be in the position after the last element which is less than pivot
                   // i.e. where the pivot should be placed
        // initially j=si as we have not found any element less than pivot
        for (int i = si; i <= ei; i++) {
            if (arr[i] < pivot) {
                if(j==mid){// if we had to put something in the place of pivot then we have to remember where we are going to place it
                    mid = i;
                }
                // if element is less than pivot then swap it with the element at j
                // and we move pivotposition to right as we have placed an element less than
                // pivot
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
                j++;// move pivot position (to be placed) to right
            }
        }
        // placing the pivot at its correct position
        arr[mid] = arr[j];
        arr[j] = pivot;
        // now pivot is at its correct position
        quickSort(arr, si, j - 1);
        quickSort(arr, j + 1, ei);
    }

    public static void main(String[] args) {
        int arr[] = { 1, 4, 5, 3, 2, -1 };
        int si = 0;
        int ei = arr.length-1;
        quickSort(arr, si, ei);
        PrintArr.print(arr);
    }
}
