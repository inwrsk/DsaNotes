package A_Arrays;
import static _Ess.Print.printArr;
//reversing the array (optimized)
// idea is to have two pointers front and back of the array and swap them 
// till they meet in the middle
public class C_ReverseArr {
    // for reversing array
    public static void reverseArr(Integer[] arr) {
        Integer start = 0, end = arr.length - 1, temp;
        while (start < end) {
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        Integer arr[] = { 1, 2, 3, 4, 5 };
        printArr(arr);// 1 2 3 4 5
        reverseArr(arr);
        printArr(arr);// 5 4 3 2 1
    }
}
