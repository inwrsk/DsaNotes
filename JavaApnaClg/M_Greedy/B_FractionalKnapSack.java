package M_Greedy;

import java.util.Arrays;
import java.util.Comparator;

//you have to fill the bag with different type of grains so that you will bag more value
//approch : pick the elements according to their price per unit
public class B_FractionalKnapSack {

    static double fractionalKnapsack(int[] val, int[] wt, int capacity) {
        double value = 0;
        int elem = val.length;
        double[][] arr = new double[elem][3];
        for (int i = 0; i < elem; i++) {
            arr[i][0] = val[i];
            arr[i][1] = wt[i];
            arr[i][2] = arr[i][0] / arr[i][1];
        }
        // sorting the entire array on the basis of 3rd column
        Arrays.sort(arr, Comparator.comparing(o -> o[2]));
        int spaceLeft = capacity;
        for (int i = elem - 1; i >= 0; i--) {
            if (spaceLeft >= arr[i][1]) {
                spaceLeft -= arr[i][1];
                value += arr[i][0];
            } else {
                value += (spaceLeft * arr[i][2]);
                spaceLeft = 0;
                break;
            }
        }
        return value;
    }

    public static void main(String[] args) {
        int[] val = { 60, 100, 120 };
        int weight[] = { 10, 20, 30 };
        int capacity = 50;
        System.out.println(fractionalKnapsack(val, weight, capacity));// 240.0
    }
}
