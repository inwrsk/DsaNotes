package A_Arrays;
//finding the maximum sum possible by a subarray
//maintaining the prefixSum array (lets say sum from oth index to till now)
//we can find any subarray [i,j] by doing prefixsum[j]-[i-1];
//resulting in saving another iteration n**3 to n**2
public class D_maxSubarraySum1 {
    public static void main(String[] args) {
        int arr[] = { 1, -2, 6, -1, 3 };
        int prefixSumArr[] = new int[arr.length];
        prefixSumArr[0] = arr[0];
        //prefixsum
        for (int i = 1; i < arr.length; i++) {
            prefixSumArr[i] = prefixSumArr[i - 1] + arr[i];
        }
        int maxSum = prefixSumArr[0];
        //iterating through every possible subarray
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int curSum = i == 0 ? prefixSumArr[j] : prefixSumArr[j] - prefixSumArr[i - 1];
                maxSum = Math.max(curSum, maxSum);
            }
        }
        System.out.println("maxSubarraySum : " + maxSum);
    }
}