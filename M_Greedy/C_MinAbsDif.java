package M_Greedy;

import java.util.Arrays;

//we have to calculate the minimum sum of absoulute differences possible for all the pairs we select
public class C_MinAbsDif {
    public static void main(String[] args) {
        int[] A = { 1, 3, 4, 5, 2 };
        int[] B = { 1, 3, 2, 4, 5 };
        // sort the arrays to get the closest pairs
        Arrays.sort(A);
        Arrays.sort(B);
        int minDif = 0;
        int maxDif = 0;
        for (int i = 0; i < A.length; i++) {
            minDif += Math.abs(A[i] - B[i]);
            maxDif += Math.abs(A[i] - B[A.length - i - 1]);
        }
        System.out.println(minDif + " " + maxDif);// 0 12
        // same order for both gives min result
        // opposite order for both gives max result
    }
}
