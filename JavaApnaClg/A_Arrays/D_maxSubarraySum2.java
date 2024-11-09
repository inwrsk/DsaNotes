package A_Arrays;
//by using kadannes algorithm O(n)
//split the array into arrays which will have cursum always +ve

public class D_maxSubarraySum2 {
    public static void main(String[] args) {
        // int[] arr = { -2, -3, 4, -1, -2, 1, 5, -3 };
        // int arr[] = { 1, -2, 6, -1, 3 };
        int arr[] = { -5, -2, -4, -3 };
        int maxSum = 0;
        int curSum = 0;
        int count = 0;//how many numbers negative (for checking)
        int maxElement = Integer.MIN_VALUE;//used in case all are negative
        for (int i = 0; i < arr.length; i++) {
            maxElement = Math.max(maxElement,arr[i]);
            //comparision to drop off the current train if the new element makes loss to the train(curSum)
            if (curSum + arr[i] < 0) {
                curSum = 0;
                count++;
            } else {
                curSum += arr[i];
            }
            //tracking what is the maxSum of subarray encountered till now.
            maxSum = Math.max(curSum, maxSum);
        }
        //if all the elements are negative
        if (count == arr.length) {
            maxSum = maxElement;
        }
        System.out.println("maxsum " + maxSum);
    }
}