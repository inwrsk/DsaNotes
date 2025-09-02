package S_Graphs;

import java.util.ArrayList;

// Cycle detection in undirected graph
public class D_CycleDetection {
    // this function is for detecting cycles in all teh disconnected or distinct
    // graphs
    static boolean DetectCycle(ArrayList<A_Edge>[] graph) {
        boolean[] isVisited = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!isVisited[i]) {
                boolean tempRes = DFS(graph, isVisited, i, -1);
                if (tempRes) {
                    return tempRes;
                }
            }
        }
        return false;
    }

    // this is for detecting cycle with in a single connected component in graph
    static boolean DFS(ArrayList<A_Edge>[] graph, boolean[] isVisited, int i, int parent) {
        // i is current node (which is to be visited now)
        // parent is parent node of current node
        isVisited[i] = true;
        for (A_Edge edge : graph[i]) {// iterating over every connection with this current node
            int dest = edge.dest;
            if (isVisited[dest]) {// if the neighbour is already visited and not parent then cycle exists
                if (dest != parent) {
                    return true;
                }
            } else { // if neighbour is not visited then get the result from recursive call
                boolean tempRes = DFS(graph, isVisited, dest, i);
                if (tempRes) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // .(1)-(3)
        // ./.....|.\
        // 0......|..\
        // .\.....|...\
        // .(2)-(4)--(5)
        // ............\
        // ............(6)
        @SuppressWarnings("unchecked")
        ArrayList<A_Edge>[] graph = new ArrayList[7];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        // Constructing the graph
        // Node 0
        graph[0].add(new A_Edge(0, 1));
        graph[0].add(new A_Edge(0, 2));
        // Node 1
        graph[1].add(new A_Edge(1, 0));
        graph[1].add(new A_Edge(1, 3));
        // Node 2,
        graph[2].add(new A_Edge(2, 0));
        graph[2].add(new A_Edge(2, 4));
        // Node 3
        graph[3].add(new A_Edge(3, 1));
        // graph[3].add(new A_Edge(3, 4));
        // graph[3].add(new A_Edge(3, 5));
        // Node 4
        graph[4].add(new A_Edge(4, 2));
        // graph[4].add(new A_Edge(4, 3));
        graph[4].add(new A_Edge(4, 5));
        // Node 5
        // graph[5].add(new A_Edge(5, 3));
        graph[5].add(new A_Edge(5, 4));
        graph[5].add(new A_Edge(5, 6));
        // Node 6
        graph[6].add(new A_Edge(6, 5));
        System.out.println(DetectCycle(graph));
        // false if 3-5 and 3-4 nodes are removed
        // true if both or any one is present
    }
}
