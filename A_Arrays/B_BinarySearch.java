package A_Arrays;
//search an element in sorted array
//logic: find the half part of the array the  key element belongs to
public class B_BinarySearch {
    public static Integer binarySearch(Integer[] arr, Integer key) {
        Integer start = 0, end = arr.length, mid;
        while (start <= end) {
            mid = start + (end - start)/2;
            if (key.equals(arr[mid])) {
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
	Integer arr[] = { 2, 5, 6, 7, 9, 1111 };
        // Integer key = 4;//-1
        // Integer key = 9;//4
        Integer key = 2;//0
        // Integer key = 1111;// 5
        System.out.println("index : " + binarySearch(arr, key));
    }
}
