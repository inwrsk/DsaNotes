package M_Greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.ArrayList;

public class A_ActivitySelection {

    static void printArr(int[][] Arr) {
        for (int i = 0; i < Arr.length; i++) {
            System.out.print(Arr[i][0] + " ");// activity indexes
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Activities are on the basis of starting time
        int start[] = { 0, 1, 3, 5, 5, 8 };// Activities 0, 1, 2, 3, 4, 5
        int end[] = { 6, 2, 4, 7, 9, 9 };
        // maintaining the activity array [index, start, end]
        int activity[][] = new int[start.length][3];
        // assign Activity index in 0th index
        // assign start index in 1st index
        // assign end index in 2nd index
        for (int i = 0; i < start.length; i++) {
            activity[i][0] = i;
            activity[i][1] = start[i];
            activity[i][2] = end[i];
        }
        // sort the activity array on the basis of end time (activity[i][2])
        // o -> o[2] is like mapping the row with the value of 3rd element index in
        // array i.e end time
        Arrays.sort(activity, Comparator.comparing(o -> o[2]));
        printArr(activity);// 1 2 0 3 4 5
        // ArrayList has a list which stores the activity indexes (done)
        ArrayList<Integer> ans = new ArrayList<>();
        int curTime = 0;
        // iterating on every activity after sorting them on end time
        for (int i = 0; i < start.length; i++) {
            ///if curTime is less than that start time of an activity
            /// we will do it
            if (curTime <= activity[i][1]) {
                ans.add(activity[i][0]);
                curTime = activity[i][2];// after doing that activity curTime becomes the end time of that
            }
        }
        System.out.println(ans);// [1, 2, 3, 5]
    }
}