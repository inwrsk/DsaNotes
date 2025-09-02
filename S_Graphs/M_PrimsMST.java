package S_Graphs;

import java.util.ArrayList;
import java.util.PriorityQueue;

// Minimum Spanning Tree (MST) is a tree that connects all the nodes of a graph with the minimum possible total edge weight for undirected connected graphs
// Prim's algorithm is used to find the Minimum Spanning Tree of a graph (choose the smallest edge at each step from all the available edges we have till that point )
// The algorithm works by selecting the edge with the minimum weight at each step (greedy approach) (by using a priority queue)
// The algorithm starts from cur node and explores the neighbours of the node and selects the edge with the minimum weight by adding all of them to pq 
// the selected node becomes cur node and the process continues
// The algorithm continues until all the nodes are visited
// simple explantion:
// 1. Start from the source node
// 2. Add all the connections from the source node to the priority queue
// 3. Explore the graph by selecting the smallest edge from the priority queue
// 4. Add the selected edge to the answer arraylist
// 5. Add all the connections (to unvisited nodes) from the destination node of the selected edge to the priority queue
// 5.1. now again select the smallest edge from the priority queue
// 6. Repeat the process until all the nodes are visited
public class M_PrimsMST {
    // Edge class to store the details of the edge (source, destination, weight) for
    // the graph and priority queue
    static class Edge implements Comparable<Edge> {
        int u;
        int v;
        int w;

        Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }

        // comparing on the basis of weights
        public int compareTo(Edge e) {
            return w - e.w;
        }
    }

    public static ArrayList<ArrayList<Integer>> calculatePrimsMST(int n, int m, ArrayList<ArrayList<Edge>> graph) {
        boolean isVisited[] = new boolean[n];
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        // starting from 0th node (source node)
        isVisited[0] = true;
        // adding all the connections from 0th node to pq
        for (int i = 0; i < graph.get(0).size(); i++) {
            int u = graph.get(0).get(i).u;
            int v = graph.get(0).get(i).v;
            int w = graph.get(0).get(i).w;
            pq.add(new Edge(u, v, w));
        }
        // exploring the graph
        while (!pq.isEmpty()) {
            // getting details of the cur edge (smallest weight edge in current pq)
            Edge cur = pq.remove();
            int u = cur.u;
            int v = cur.v;
            int w = cur.w;
            // if the destination of edge not yet visited
            if (!isVisited[v]) {
                isVisited[v] = true;
                // adding this connection to answer arrayList
                ArrayList<Integer> edge = new ArrayList<>();
                edge.add(u);
                edge.add(v);
                edge.add(w);
                ans.add(edge);
                // explore the neighbours of v also
                for (Edge e : graph.get(v)) {
                    // e is one of the connection from v
                    if (!isVisited[e.v]) {
                        pq.add(e);
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 5;// number of nodes
        int m = 6;// number of edges
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        // 0th node
        graph.get(0).add(new Edge(0, 1, 2));
        graph.get(0).add(new Edge(0, 2, 4));
        // 1st node
        graph.get(1).add(new Edge(1, 0, 2));
        graph.get(1).add(new Edge(1, 2, 1));
        // 2nd node
        graph.get(2).add(new Edge(2, 0, 4));
        graph.get(2).add(new Edge(2, 1, 1));
        graph.get(2).add(new Edge(2, 3, 3));
        graph.get(2).add(new Edge(2, 4, -5));
        // 3rd node
        graph.get(3).add(new Edge(3, 2, 3));
        graph.get(3).add(new Edge(3, 4, 2));
        // 4th node
        graph.get(4).add(new Edge(4, 3, 2));
        graph.get(4).add(new Edge(4, 2, -5));

        // graph :
        // 0 - 1 : 2
        // 0 - 2 : 4
        // 1 - 0 : 2
        // 1 - 2 : 1
        // 2 - 0 : 4
        // 2 - 1 : 1
        // 2 - 3 : 3
        // 2 - 4 : -5
        // 3 - 2 : 3
        // 3 - 4 : 2
        // 4 - 3 : 2
        // 4 - 2 : -5
        ArrayList<ArrayList<Integer>> ans = calculatePrimsMST(n, m, graph);
        for (ArrayList<Integer> edge : ans) {
            System.out.println(edge.get(0) + " - " + edge.get(1) + " : " + edge.get(2));
        }
    }
}
// Output:
// 0 - 1 : 2
// 1 - 2 : 1
// 2 - 4 : -5
// 4 - 3 : 2