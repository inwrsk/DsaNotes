package S_Graphs;

import java.util.Arrays;

// Bellman Ford algorithm is used to find the shortest path from the source node to all other nodes in a weighted graph
// It can also detect negative cycles in the graph
// The algorithm works by relaxing all the edges V-1 times
// If there exists a negative cycle the distance of the destination node will be updated in the Vth iteration
public class L_BellmanFord {
    static int[] bellmanFord(int V, int[][] edges, int src) {
        // distance array to store the minimum distance from the source
        int[] d = new int[V];
        // initialize the distance array with infinity
        Arrays.fill(d, Integer.MAX_VALUE);
        // distance from source to source is 0
        d[src] = 0;
        // relax all the edges V-1 times
        for (int i = 1; i <= V; i++) {
            // for each edge
            for (int j = 0; j < edges.length; j++) {
                // getting the edge data
                // u -> source node
                int u = edges[j][0];
                // v -> destination node
                int v = edges[j][1];
                // w -> weight of the edge
                int w = edges[j][2];
                // if the distance of the source node is not infinity and the distance of the
                // destination node is greater than the distance of the source node + weight of
                // the edge
                if (d[u] != Integer.MAX_VALUE && d[v] > d[u] + w) {
                    // if there exists a negative cycle the loop will run for the Vth time and the
                    // distance of the destination node will be updated
                    if (i == V) {
                        int[] arr = new int[1];
                        arr[0] = -1;
                        // return -1 if there exists a negative cycle
                        return arr;
                    }
                    // else update the distance of the destination node
                    d[v] = d[u] + w;
                }
            }
        }
        return d;
    }

    public static void main(String[] args) {
        int V = 5;
        int[][] edges = { { 0, 1, 2 }, { 0, 2, 4 }, { 1, 2, 1 }, { 2, 3, 3 }, { 3, 4, 2 }, { 4, 2, -5 } };
        // edge format -> {source, destination, weight}
        // edges :
        // 0 -> 1 : 2
        // 0 -> 2 : 4
        // 1 -> 2 : 1
        // 2 -> 3 : 3
        // 3 -> 4 : 2
        // 4 -> 2 : -5
        int src = 0;
        int[] distance = bellmanFord(V, edges, src);
        if (distance[0] == -1) {
            System.out.println("Negative cycle detected");
        } else {
            for (int i = 0; i < V; i++) {
                System.out.println("Distance from " + src + " to " + i + " is " + distance[i]);
                // Output:
                // Distance from 0 to 0 is 0
                // Distance from 0 to 1 is 2
                // Distance from 0 to 2 is 3
                // Distance from 0 to 3 is 6
                // Distance from 0 to 4 is 8

            }
        }
    }
}
