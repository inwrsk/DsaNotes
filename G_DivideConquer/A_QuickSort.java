package G_DivideConquer;

import static _Ess.Print.printArr;

// choose a pivot element and seperate the elements less than it to left side and greater than it to right side
// and now apply the technique on both sides

public class A_QuickSort {

    public static void quickSort(Integer[] arr, Integer si, Integer ei) {

        // base case (write this after you have written the recursive calls, then it will make sense)
        if (si >= ei)
            return;
        // logic part
        Integer mid = (si + ei) / 2;
        Integer pivot = arr[mid]; // selecting middle element will be better for time complexity (nlogn)
        Integer j = si; // j will be in the position after the last element which is less than pivot
                   // i.e. where the pivot should be placed
        // initially j=si as we have not found any element less than pivot
        for (Integer i = si; i <= ei; i++) {
            if (arr[i] < pivot) {
                if(j.equals(mid)){// if we had to put something in the place of pivot then we have to remember where we are going to place it
                    mid = i;
                }
                // if element is less than pivot then swap it with the element at j
                // and we move pivotposition to right as we have placed an element less than
                // pivot
                Integer temp = arr[j];
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
        Integer arr[] = { 5, 1, 4, 5, 3, 2, -1 };
        Integer si = 0;
        Integer ei = arr.length-1;
        quickSort(arr, si, ei);
        printArr(arr);
    }
}
