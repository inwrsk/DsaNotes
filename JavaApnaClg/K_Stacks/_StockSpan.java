package K_Stacks;

import java.util.Stack;

//we have to find the maximum no of consecutive days that are less than or equal to todays price
//i.e 1, 3, 3
//i.e 100, 80, 60, 70, 60, 85, 100
public class _StockSpan {
    static int findStreak(int[] stocks) {
        int maxStreak = 0;
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < stocks.length; i++) {
            // clear the stack till the peek element is greater than the current stock
            // element
            while (!s.isEmpty() && stocks[s.peek()] <= stocks[i]) {
                s.pop();
            }
            // if there exist an element greater than the current stock element note its
            // index
            int prevPeek = 0;
            if (s.size() >= 1) {
                prevPeek = s.peek();
            }
            s.push(i);
            // if there is no element greater than current element till now
            // max streak till now is index+1 i.e total elements till now
            if (s.size() == 1) {
                maxStreak = s.peek() + 1;
            } // if there exists another element maxstreak is max (no of elements b/w then new
              // peek and old peek, maxStreak)
            else {
                maxStreak = Math.max(maxStreak, s.peek() - prevPeek);
            }
        }
        System.out.println(s);
        return maxStreak;
    }

    public static void main(String[] args) {
        // int[] stocks = { 1, 5, 1, 3, 3, 2 };
        int[] stocks = { 100, 80, 60, 70, 60, 85, 100 };
        int maxStreak = findStreak(stocks);
        System.out.println("max Streak : " + maxStreak);
    }
}