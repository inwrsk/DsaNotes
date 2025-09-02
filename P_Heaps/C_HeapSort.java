package P_Heaps;
// sorting an array using heap

// Time complexity: O(nlogn)
// Space complexity: O(1)
// stable: No (means the relative order of equal elements may change) (not a big deal)
// idea : is the root always contains the extreme element (max or min) of the heap
// so if we remove root element every time and fix the heap, we will get the sorted array
public class C_HeapSort {
    // heapify() will fix the position of the element (as heap is deformed after
    // removing the root element (in this case))
    static void heapify(int start, int end, int arr[]) {// heapify the max heap
        // we take the max element from the children and swap it with the parent
        int pIdx = start;
        int leftIdx = (pIdx * 2 + 1);
        int rightIdx = leftIdx + 1;
        int swapIdx = pIdx;
        // if left child exists and is greater than parent
        if (leftIdx <= end && arr[leftIdx] > arr[swapIdx]) {
            swapIdx = leftIdx;
        }
        // if right child exists and is greater than parent
        if (rightIdx <= end && arr[rightIdx] > arr[swapIdx]) {
            swapIdx = rightIdx;
        }
        if (swapIdx != pIdx) {// if any child is greater than parent
            int temp = arr[swapIdx];
            arr[swapIdx] = arr[pIdx];
            arr[pIdx] = temp;
            // repeat this process with the changed child
            heapify(swapIdx, end, arr);
        }
    }

    static void print(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void heapSort(int arr[]) {
        // preparing a maxheap
        // iterating from last non-leaf node (or next node to it) to root node
        // as heapifying the leaf nodes won't make any sense they will stay there only
        for (int i = arr.length / 2; i >= 0; i--) { // there are n/2 non-leaf nodes in a heap
            heapify(i, arr.length - 1, arr);
        }
        // sorting the maxheap
        // from 0 to j the array is not sorted
        int j = arr.length - 1;
        while (j > 0) {
            // swap first and last element (placing the extreme element at the end of the
            // unsorted array)
            int temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            j--;
            // now fix the heap as the root element is changed
            // fixing the root element
            heapify(0, j, arr);
        }
    }

    public static void main(String[] args) {
        int arr[] = { 4, 1, 3, 9, 7 };
        heapSort(arr);
        print(arr);// 1 3 4 7 9
    }
}
