package A_Arrays;
//finding the maximum sum possible by a subarray
//maintaining the prefixSum array (lets say sum from oth index to till now)
//we can find any subarray sum [i,j] by doing prefixsum[j]-prefixsum[i-1];
//resulting in saving another iteration n**3 to n**2 (compared to bruteforce)
// similar to DynamicProgramming
public class D_maxSubarraySum1 {
	
	public static void main(String[] args) {
		
		Integer arr[] = { 1, -2, 6, -1, 3 };
		Integer prefixSumArr[] = new Integer[arr.length];
		prefixSumArr[0] = arr[0];

		//prefixsum
		for (Integer i = 1; i < arr.length; i++) {
			prefixSumArr[i] = prefixSumArr[i - 1] + arr[i];
		}

		Integer maxSum = prefixSumArr[0];

		//iterating through every possible subarray
		for (Integer i = 0; i < arr.length; i++) {
		      for (Integer j = i; j < arr.length; j++) {
			    Integer curSum = i.equals(0) ? prefixSumArr[j] : prefixSumArr[j] - prefixSumArr[i - 1];
			    maxSum = Math.max(curSum, maxSum);
		      }
		}

		System.out.println("maxSubarraySum : " + maxSum);//8

	}

}
