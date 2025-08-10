package A_Arrays;
import _Ess.PrintArr;
//reversing the array (optimized)
// idea is to have two pointers front and back of the array and swap them 
// till they meet in the middle
public class C_ReverseArr {
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
        PrintArr.print(arr);// 1 2 3 4 5
        reverseArr(arr);
        PrintArr.print(arr);// 5 4 3 2 1
    }
}
