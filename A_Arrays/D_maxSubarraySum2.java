package A_Arrays;

// by using kadannes algorithm O(n)
// The idea is to find the subarray with the maximum sum by maintaining a running sum (curSum).
// We start from the first element and keep track of curSum, which represents the sum from 
// the starting element to the current element.
//
// If curSum becomes negative at any point, it means that including the previous subarray 
// in our sum reduces the overall value. So, we discard that subarray and start a new one 
// from the current element.
//
// While iterating, we continuously update maxSum to store the highest curSum encountered so far. 
// The value of maxSum at the end of the iteration is our answer.
//
// Edge Case: If all elements in the array are negative, the best choice is to pick the 
// maximum element from the array as our result.

public class D_maxSubarraySum2 {
    public static void main(String[] args) {
        Integer[] arr = { -2, -3, 4, -1, -2, 1, 5, -3 };// ans = 7 (4,-1,-2,1,5)
        // Integer arr[] = { 1, -2, 6, -1, 3 };// ans = 8 (6,-1,3)
        // Integer arr[] = { -5, -2, -4, -3 }; // ans = -2 (-2)
        Integer maxSum = 0;
        Integer curSum = 0;
        Integer maxElement = Integer.MIN_VALUE;//used in case all are negative
        for (Integer i = 0; i < arr.length; i++) {
            maxElement = Math.max(maxElement,arr[i]);
            //comparision to drop off the current train (sub array) if the new element makes loss to the train(curSum)
            curSum = Math.max(0, curSum+arr[i]);
            //tracking what is the maxSum of subarray encountered till now.
            maxSum = Math.max(curSum, maxSum);
        }
        //if all the elements are negative
        if (maxElement < 0) {
            maxSum = maxElement;
        }
        System.out.println("maxsum " + maxSum);
    }
}
