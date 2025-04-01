package K_Stacks;

import java.util.Stack;

// we have to find the maximum no of consecutive days that are less than or equal to ith day price
// lets say we have an array of stock prices
// i.e 100, 80, 60, 70, 60, 85, 100
// for every day if we found out the max no of days that are having less than or equal to current day is
// [1(only 100), 1(only 80 or only 100), 1 (only 60 or 80 or 100), 2(60 and 70), 2(60 and 70), 5(from 85 to 80), 7(upto 100 all)] this is the array of streaks for every day 
// so [1, 1, 1, 2, 2, 5, 7] is the streak array
// so the max streak is 7
// how to find this streak array?
// lets say today is ith day and we have data of previous days i.e the days whose prices are greater than today's price
// so we can say the data till today is in decreasing order 
// the differences between one day and another day in the past is the local streak that stock prices are less than or equal to that one day till another day (past) 
// take all those such streaks into account and the max of all those streaks is the max streak for that one day
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
        System.out.println("max Streak : " + maxStreak);//7
    }
}