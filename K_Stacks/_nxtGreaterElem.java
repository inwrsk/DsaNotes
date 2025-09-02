package K_Stacks;

import java.util.Stack;

//we have to return a array which contains next immediate greater element for an element
// - if there is no element greater than the current elem put -1 in that index and continue
// first if you want nextgreater (towards right)
// start from right till 0th index
// maintain a stack which will contain indexes of elements which are in increasing order after the current element
// when we reach a element we will find the (immediate greater element) in stack (we'll store that index in the array)
// rather than iterating from that element to the end
// and also we remove if there are elements less than this current element in the stack 
// as for the next iteration if the next element can find the bigger element nearer why search for after it 
// if they can't find any thing bigger
public class _nxtGreaterElem {
    static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    static int[] findGreaterElem(int[] arr) {// O(n)
        int resArray[] = new int[arr.length];
        Stack<Integer> s = new Stack<>();// stack contains the index's of elements
        for (int i = arr.length - 1; i >= 0; i--) {
            // for every index we check if the stack contains the element's indexes
            // only if they are greater than the current element
            while (!s.isEmpty() && arr[i] >= arr[s.peek()]) {
                // we are removing the elements if they are smaller than or equal to the current
                // element
                s.pop();
            }
            // now for ith index stack will contain the index of elements greater than it
            if (s.isEmpty()) {
                resArray[i] = -1;
            } else {
                resArray[i] = arr[s.peek()];
            }
            s.push(i);
        }
        return resArray;
    }

    public static void main(String[] args) {
        int[] origArray = { 6, 8, 0, 1, 3 };
        int[] resArray = findGreaterElem(origArray);
        printArr(resArray);// 8 -1 1 3 -1
    }
}
