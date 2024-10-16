package A_Arrays;
//search an element in sorted array
//logic: find the half key element belongs to
public class B_BinarySearch {
    public static int binarySearch(int[] arr, int key) {
        int start = 0, end = arr.length, mid;
        while (start <= end) {
            mid = (start + end) / 2;
            if (key == arr[mid]) {
                return mid;
            }
            if (key > arr[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int arr[] = { 2, 5, 6, 7, 9, 11 };
        // int key = 4;//-1
        // int key = 9;//4
        // int key = 2;//0
        int key = 11;// 5
        System.out.println("index : " + binarySearch(arr, key));
    }
}
