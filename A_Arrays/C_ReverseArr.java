package A_Arrays;
//reversing the array (optimized)
public class C_ReverseArr {
    // prints array
    public static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // for reversing array
    public static void reverseArr(int[] arr) {
        int start = 0, end = arr.length - 1, temp;
        while (start < end) {
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5 };
        printArr(arr);// 1 2 3 4 5
        reverseArr(arr);
        printArr(arr);// 5 4 3 2 1
    }
}
