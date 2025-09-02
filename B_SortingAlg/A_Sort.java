package B_SortingAlg;
import _Ess.PrintArr;

import java.util.Arrays;
//Arrays.sort(arr) O(nlogn)
//import java.util.Collections;

public class A_Sort {

    // bubble sort O(n2)
    // swap the adjacent elements if they are in wrong order
    // eventually the largest element will be at the end
    public static void bubbleSort(int[] arr) {// arrays are passed by reference while variable are by value in java
        for (int i = 1; i <= arr.length - 1; i++) {// total n-1 iterations (as for two elements we need once, for three we need twice)
            // imagine: if the smallest element is at the end then it will take n-1 iterations to reach first position
            int swaps = 0;// to check if the array is already sorted
            for (int j = 0; j < arr.length - i; j++) {// iteratign over the unsorted part
                // for every iteration the largest element will be at the end i.e we are reducing the part to be iterated over by using i
                if (arr[j] > arr[j + 1]) {
                    swaps++;
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            //if in this unsorted part no swaps are done then the array is already sorted
            if (swaps == 0) {// if the array is already sorted then swaps are 0
                break;
            }
        }
    }

    // selection sort
    // same as the bubble sort interms of finding the extreme element
    // it finds the maximum element and places it at the last
    public static void selectionSort(int[] arr) {
        // we should repeat the process is n-1 times (because placing atleast n-1
        // large elements at end makes it sorted)
        for (int i = 0; i < arr.length - 1; i++) {
            int maxPos = 0;// assuming the first element is the max
            int updations = 0;// to check if the array is already sorted
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[maxPos] < arr[j]) {
                    maxPos = j;
                    updations++;
                }
            }
            // after finding the max element swap it with the last element of the array wrt
            // current iteration
            if (updations == arr.length - 1 - i) {// if the array is already sorted then updations are n-1-i
                return;
            }
            int temp = arr[maxPos];
            arr[maxPos] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
    }

    // insertion sort
    // the array divided into two parts sorted and unsorted
    // we will pick element in unsorted and place it in its correct position in
    // sorted after moving the elements greater than it to right for creating space for it
    public static void insertionSort(int[] arr) {// in this example we will do ascending order
        // let the first element be sorted i.e arr[0] we have to place the unsorted values like arr[1] in the correct position
        for (int i = 1; i < arr.length; i++) {
            int cur = arr[i];// we picked up the elem to be inserted
            int eiOfSortedArr = i - 1;
            // finding the pos starting from the back of sorted array which is in asc order till where the elements are smaller than cur starts
            while (arr[eiOfSortedArr] > cur && eiOfSortedArr >= 0 ) {
                // shifting the elements greater than curElem in sorted part to right
                // so that we can place the curElem in its correct position
                arr[eiOfSortedArr + 1] = arr[eiOfSortedArr];
                eiOfSortedArr--;
            }
            // now we found the index which is either contains the element which is less than cur or
            // or it is -1 that is the value we picked (cur) is the shortest of all
            arr[eiOfSortedArr + 1] = cur;
        }
    }

    // counting sort (suitable for positive elements and small range) as we use a
    // array of size maxElement
    // we maintain a countArr we store the count of each element in the given array of range 0 to maxElement in the given unsorted array
    // then we iterate over the countArr and place the elements in the original
    // array according to the count
    public static void countingSort(int[] arr) {// time complexity O(n+maxElement)
        // finding the maxElement
        int mx = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++)
            mx = Math.max(mx, arr[i]);
        // making of countArr
        int countArr[] = new int[mx + 1];
        for (int i = 0; i < arr.length; i++)
            countArr[arr[i]]++;
        // sorting
        int j = 0;
        for (int i = 0; i < countArr.length; i++) {
            while (countArr[i] > 0) {
                countArr[i]--;
                arr[j] = i;
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = { 1, 3, 4, 5, 4, 2 };
        System.out.print("before sorting : ");
        PrintArr.print(arr);// 1 3 4 5 4 2
        bubbleSort(arr);
        System.out.print("after sorting : ");
        PrintArr.print(arr);// 1 2 3 4 4 5

        // Arrays.sort(arr);// sorts the array
        // when we want to sort in descending order we have to use Collections.reverseOrder() as an argument
        // and for that it takes only Integer datatype array not primitive type like int[]
        // Arrays.sort(arr, Collections.reverseOrder()); // error as arr is int type
        // Integer Arr[] = { 1, 3, 5, 4, 2 };
        // Arrays.sort(Arr, Collections.reverseOrder());// 54321
        // sorting 0, 1, 2 indexes
        // Arrays.sort(Arr, 0, 3, Collections.reverseOrder());// 5 3 1 4 2
        // Arrays.sort(arr, 0, 5);// (from index to toIndex(not included))
        // PrintArr.print(arr);// 1 3 4 4 5 2
        // System.out.println(arr); // prints address not values
        

    }
}