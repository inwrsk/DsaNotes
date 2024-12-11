package M_Greedy;

import java.util.ArrayList;
import java.util.Collections;

// you are given jobs with deadlines and profits 
// perform the jobs so that you can bag good profit
// sort the jobs in order of profits
// now start from the top
// if there is a slot empty from deadline to 1st hour then complete it (check from deadline to 1st hour)
// so that we can perfrom any other tasks with less deadline also
public class E_JobSequencing {
    static class Job {
        int id;
        int deadLine;
        int profit;

        Job(int id, int deadLine, int profit) {
            this.id = id;
            this.deadLine = deadLine;
            this.profit = profit;
        }
    }

    public static void main(String[] args) {
        int[][] jobs = { { 2, 20 }, { 1, 10 }, { 2, 15 }, { 3, 5 }, { 3, 3 } };
        // we can also sort 2d array by arrays.sort to try sorting objects:
        // using collections.sort we should have a list so:
        ArrayList<Job> jobs2 = new ArrayList<>();
        int maxDeadLine = 0;
        for (int i = 0; i < jobs.length; i++) {
            Job newJob = new Job(i + 1, jobs[i][0], jobs[i][1]);
            jobs2.add(newJob);
            maxDeadLine = Math.max(maxDeadLine, newJob.deadLine);
        }
        // for maintaining record for what filled and what not
        int[] timeLine = new int[maxDeadLine];
        // Sort the jobs according to the profit (in decreaseing order)
        // for ascending order a - b
        Collections.sort(jobs2, (a, b) -> b.profit - a.profit);
        // now time to complete the jobs (iterate through every job in the order of
        // jobs2 (as it contains maxprofit to least))
        int profit = 0;
        int nJobs = 0;
        System.out.print("jobs are: ");
        for (int i = 0; i < jobs.length; i++) {
            int hour = jobs2.get(i).deadLine - 1;
            while (hour >= 0) {
                if (timeLine[hour] == 0) {
                    timeLine[hour] = 1;
                    profit += jobs2.get(i).profit;
                    System.out.print(jobs2.get(i).id + " ");// jobs are: 1 3 4
                    nJobs += 1;
                    break;
                }
                hour--;
            }
        }
        System.out.println("\n" + nJobs + " " + profit);// 3 40
    }
}
