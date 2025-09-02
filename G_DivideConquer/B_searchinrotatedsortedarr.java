package G_DivideConquer;

// you are given a sorted array that is rotated at some unknown point. Find the index of target element in the array.
// comparing to binary search with normal sorted array:
// target less than mid element: go left because no elements in right will be less than mid element and vice versa.
// but here even if target is less than mid element, it can be in right side of mid element.
// and even if target is greater than mid element, it can be in left side of mid element.
// they are based on which slope mid element is on.
// so determining the slope of mid element is important.

// Visualization: 4,5,6,7,1,2,3
//       7
//     6
//   5
// 4
//             3
//           2
//         1

public class B_searchinrotatedsortedarr {
    public static int search(int arr[], int tar, int si, int ei) {
        if (si > ei) {
            return -1;
        }

        int mid = (si + ei) / 2;
        if (tar == arr[mid]) {
            return mid;
        }

        // mid on L1
        if (arr[si] <= arr[mid]) {
            if (arr[si] <= tar && tar <= arr[mid]) { // go left
                return search(arr, tar, si, mid - 1);
            } else { // go right
                return search(arr, tar, mid + 1, ei);
            }
        }

        // mid on L2
        else {
            if (arr[mid] <= tar && tar <= arr[ei]) { // go right
                return search(arr, tar, mid + 1, ei);
            } else { // go left
                return search(arr, tar, si, mid - 1);
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = { 4, 5, 6, 7, 1, 2, 3 };
        System.out.println(search(arr, 2, 0, 7));// 5
    }
}
