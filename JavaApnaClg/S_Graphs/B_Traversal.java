package S_Graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

// Depth first search is using recursion
// visiting the currNode is visiting the unvisted neighbours of it sequentially
// Breadth first search for Graph using Queue
// insert the neighbours if the current node is unvisited
public class B_Traversal {// O(V+E) for both
    // ........(1)---(3)
    // ......./.......|.\
    // ......0........|..\
    // .......\.......|...\
    // ........(2)---(4)--(5)
    // .....................\
    // .....................(6)

    static void BFS(ArrayList<A_Edge>[] graph) {
        // Initialize the Queue
        Queue<ArrayList<A_Edge>> que = new ArrayDeque<>();
        // Initialize isVisited Array
        boolean[] isVisited = new boolean[graph.length];// by default all values will be false
        // pushing the source
        que.add(graph[0]);
        // running the loop till the que becomes empty
        while (!que.isEmpty()) {
            // picking the first node
            ArrayList<A_Edge> currNode = que.remove();
            // if not visited yet
            if (!isVisited[currNode.get(0).src]) {
                isVisited[currNode.get(0).src] = true;
                // adding all the neighbours of it to queue
                for (A_Edge neighbour : currNode) {
                    que.add(graph[neighbour.dest]);
                }
                System.out.print(currNode.get(0).src + " ");// 0 1 2 3 4 5 6
            }
        }
    }

    // graph, isVisited is to track which nodes have been visited (as we used
    // recursion), currNode's arraylist
    static void DFS(ArrayList<A_Edge>[] graph, boolean[] isVisited, ArrayList<A_Edge> edgesOfNode) {
        // visiting the currNode
        System.out.print(edgesOfNode.get(0).src + " ");
        isVisited[edgesOfNode.get(0).src] = true;
        // iterating through neighbours of curNode
        for (int i = 0; i < edgesOfNode.size(); i++) {
            // edge to a neighbour
            A_Edge edge = edgesOfNode.get(i);
            // if that neighbour is unvisited
            if (!isVisited[edge.dest]) {
                // dfs the neighbour
                DFS(graph, isVisited, graph[edge.dest]);
            }
        }
    }

    public static void main(String[] args) {
        // Creating a Graph of n nodes (so array of Arraylists)
        // array of size n (for every node)
        // ArrayList is no of edges for the node (src, dest, weight)
        // declaration of array of arraylist
        ArrayList<A_Edge>[] graph = new ArrayList[7];// in simple terms we just created array of pointers
        // we have a array which can hold the arrayLists of type A_Edge but they are not
        // initialized yet
        // Initialization
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
        // Breadth first search
        BFS(graph);
        System.out.println();
        // Depth first Search
        boolean[] isVisited = new boolean[graph.length];
        DFS(graph, isVisited, graph[0]);// 0 1 3 4 2 5 6
    }
}
