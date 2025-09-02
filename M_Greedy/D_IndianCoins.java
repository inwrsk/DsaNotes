package M_Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

//Greedy approch works with canonical coin system 
//indian coin system is also canonial coin system
// we have to find the minimum number of coins to pay the given amount
public class D_IndianCoins {
    public static void main(String[] args) {
        Integer coins[] = { 500, 50, 5, 100, 2, 20, 10, 200, 1 };
        int amount = 1346;
        // sort the coins (for using inbuilt sort we took Integer type)
        Arrays.sort(coins, Comparator.reverseOrder());
        ArrayList<Integer[]> ans = new ArrayList<>();
        for (int i = 0; i < coins.length; i++) {
            if (amount >= coins[i]) {
                Integer curCoins = Math.floorDiv(amount, coins[i]);
                Integer[] cur = { curCoins, coins[i] };
                ans.add(cur);
                amount -= curCoins * coins[i];
            }
        }
        for (int i = 0; i < ans.size(); i++) {
            System.out.print("[" + ans.get(i)[0] + ", " + ans.get(i)[1] + "] ");
            // [2, 500] [1, 200] [1, 100] [2, 20] [1, 5] [1, 1]
        }
    }
}
