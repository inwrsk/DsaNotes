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
    // push the largest element to last
    // push the second largest to second last ...
    // for optimization track the noof swaps in a iteration
    // if it is 0 then we can exit the process as the loop is already sorted
    public static void bubbleSort(int[] arr) {// arrays are passed by reference while variable are by value in java
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // selection sort
    // same as the bubble sort interms of finding the smallest element
    // but reduces the unnecessay swaps interemediate
    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minPos = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minPos] > arr[j]) {
                    minPos = j;
                }
            }
            int temp = arr[minPos];
            arr[minPos] = arr[i];
            arr[i] = temp;
        }
    }

    // insertion sort
    // the array divided into two parts sorted and unsorted
    // we will pick element in unsorted and place it in sorted
    public static void insertionSort(int[] arr) {
        // let the first element be sorted
        for (int i = 1; i < arr.length; i++) {
            int cur = arr[i];
            int prev = i - 1;
            // finding the pos where the elements are smaller than cur starts
            while (prev >= 0 && arr[prev] > cur) {
                arr[prev + 1] = arr[prev];
                prev--;
            }
            arr[prev + 1] = cur;
        }
    }

    // counting sort (for positive elements)
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
        int arr[] = { 5, 2, 1, 3, 4 };
        System.out.print("before sorting : ");
        printArr(arr);

        // Arrays.sort(arr);//1 2 3 4 5
        // Arrays.sort(arr, Collections.reverseOrder()); // error as arr is int type
        // Integer Arr[] = { 1, 3, 5, 4, 2 };
        // Arrays.sort(Arr, Collections.reverseOrder());// 54321
        // Arrays.sort(Arr, 0, 3, Collections.reverseOrder());// 5 3 1 4 2
        // Arrays.sort(arr, 0, 3);// 1 2 5 3 4 (from index ant to index(not included))

        countingSort(arr);
        System.out.print("after sorting : ");
        printArr(arr);

    }
}