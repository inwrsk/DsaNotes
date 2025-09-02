package P_Heaps;

import java.util.ArrayList;

public class B_Heap {
    static class Heap {// min heap
        ArrayList<Integer> arr = new ArrayList<>();

        void add(int data) {
            arr.add(data);// add at last
            int childIdx = arr.size() - 1;
            int parIdx = (childIdx - 1) / 2;
            // now fix the position (fix the heap)
            while (parIdx >= 0 && arr.get(parIdx) > arr.get(childIdx)) {
                int temp = arr.get(childIdx);
                arr.set(childIdx, arr.get(parIdx));
                arr.set(parIdx, temp);
                childIdx = parIdx;
                parIdx = (childIdx - 1) / 2;
            }
        }

        // peek() will return the root element of the heap
        int peek() {
            return arr.get(0);
        }

        // heapify() will fix the position of the element
        void heapify(int i) {
            // now fix the position (fix the heap)
            int c1 = 2 * i + 1;
            int c2 = 2 * i + 2;
            int swapIdx = i;
            if (c1 <= (arr.size() - 1) && arr.get(c1) < arr.get(i)) {// if even one child exists
                swapIdx = c1;
            }
            if (c2 <= (arr.size() - 1) && arr.get(c2) < arr.get(c1)) {
                swapIdx = c2;
            }
            if (swapIdx != i) {
                int temp = arr.get(swapIdx);
                arr.set(swapIdx, arr.get(i));
                arr.set(i, temp);
                heapify(swapIdx);
            }
        }

        // remove() will remove the root element of the heap
        int remove() {
            // swap first and last node and delete last position
            int res = arr.get(0);
            arr.set(0, arr.get(arr.size() - 1));
            arr.remove(arr.size() - 1);
            // now fix the position (fix the heap)
            heapify(0);
            return res;
        }

        boolean isEmpty() {
            return arr.size() == 0;
        }
    }

    public static void main(String[] args) {
        Heap h = new Heap();
        h.add(3);
        h.add(4);
        h.add(1);
        h.add(5);
        while (!h.isEmpty()) {
            System.out.print(h.peek() + " ");// 1 3 4 5
            h.remove();
        }
        System.out.println();
    }
}
