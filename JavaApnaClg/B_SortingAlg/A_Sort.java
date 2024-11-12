package B_SortingAlg;

//import java.util.Arrays;
//Arrays.sort(arr) O(nlogn)
//import java.util.Collections;

public class A_Sort {
    // print the array
    public static void printArr(int[] Arr) {
        for (int i = 0; i < Arr.length; i++) {
            System.out.print(Arr[i] + " ");
        }
        System.out.println();
    }

    // bubble sort O(n2)
    // swap the adjacent elements if they are in wrong order
    // eventually the largest element will be at the end
    public static void bubbleSort(int[] arr) {// arrays are passed by reference while variable are by value in java
        for (int i = 0; i < arr.length - 1; i++) {
            int swaps = 0;// to check if the array is already sorted
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swaps++;
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
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
    // sorted after moving the elements greater than it to right
    public static void insertionSort(int[] arr) {
        // let the first element be sorted
        for (int i = 1; i < arr.length; i++) {
            int cur = arr[i];
            int prev = i - 1;
            // finding the pos where the elements are smaller than cur starts
            while (prev >= 0 && arr[prev] > cur) {
                // shifting the elements greater than curElem in sorted part to right
                // so that we can place the curElem in its correct position
                arr[prev + 1] = arr[prev];
                prev--;
            }
            arr[prev + 1] = cur;
        }
    }

    // counting sort (suitable for positive elements and small range) as we use a
    // array of size maxElement
    // we maintain a countArr we store the count of each element in the given array
    // then we iterate over the countArr and place the elements in the original
    // array according to the count
    public static void countingSort(int[] arr) {
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
        int arr[] = { 1, 3, 4, 5, 2 };
        System.out.print("before sorting : ");
        printArr(arr);

        // Arrays.sort(arr);//1 2 3 4 5
        // Arrays.sort(arr, Collections.reverseOrder()); // error as arr is int type
        // Integer Arr[] = { 1, 3, 5, 4, 2 };
        // Arrays.sort(Arr, Collections.reverseOrder());// 54321
        // Arrays.sort(Arr, 0, 3, Collections.reverseOrder());// 5 3 1 4 2
        // Arrays.sort(arr, 0, 3);// 1 2 5 3 4 (from index ant to index(not included))

        bubbleSort(arr);
        System.out.print("after sorting : ");
        printArr(arr);

    }
}