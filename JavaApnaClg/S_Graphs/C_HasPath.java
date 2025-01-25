package S_Graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

// check if path exists from source to destination
// traverse by dfs or bfs from source if you find destination return true else false
public class C_HasPath {
    // ........(1)---(3)
    // ......./.......|.\
    // ......0........|..\
    // .......\.......|...\
    // ........(2)---(4)--(5)
    // .....................\
    // .....................(6)
    static boolean bfs(ArrayList<A_Edge>[] graph, int source, int destination) {
        Queue<ArrayList<A_Edge>> que = new ArrayDeque<>();
        que.add(graph[source]);
        boolean isVisited[] = new boolean[graph.length];
        while (!que.isEmpty()) {
            ArrayList<A_Edge> curNodeEdges = que.remove();
            int cur = curNodeEdges.get(0).src;
            if (destination == cur) {
                return true;
            }
            if (!isVisited[cur]) {
                for (int i = 0; i < curNodeEdges.size(); i++) {
                    que.add(graph[curNodeEdges.get(i).dest]);
                }
            }
            isVisited[cur] = true;
        }
        return false;
    }

    public static void main(String[] args) {
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
        graph[3].add(new A_Edge(3, 4));
        graph[3].add(new A_Edge(3, 5));
        // Node 4
        graph[4].add(new A_Edge(4, 2));
        graph[4].add(new A_Edge(4, 3));
        graph[4].add(new A_Edge(4, 5));
        // Node 5
        graph[5].add(new A_Edge(5, 3));
        graph[5].add(new A_Edge(5, 4));
        graph[5].add(new A_Edge(5, 6));
        // Node 6
        graph[6].add(new A_Edge(6, 5));
        System.out.println(bfs(graph, 1, 6));// true
        System.out.println(bfs(graph, 1, 7));// false
        System.out.println(bfs(graph, 1, 1));// true
    }
}
