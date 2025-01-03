package P_Heaps;

import java.util.PriorityQueue;

// we have to connect ropes with minimum cost
// cost of connecting two ropes is the sum of their lengths
// the solution is connect the two smallest ropes at each step
// to achieve solution we will use min heap
// that will give minimum rope at root always
public class E_ConnectRopes {
    public static int minCost(int[] arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : arr) {
            pq.add(i);
        }
        int cost = 0;
        while (pq.size() > 1) {
            int a = pq.remove();
            int b = pq.remove();
            cost += (a + b);
            pq.add(a + b);
        }
        return cost;
    }

    public static void main(String[] args) {
        // arr is length of ropes
        int arr[] = { 4, 3, 2, 6 };
        System.out.println(minCost(arr));// 29
    }
}
