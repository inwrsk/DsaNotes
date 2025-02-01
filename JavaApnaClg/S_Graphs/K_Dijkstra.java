package S_Graphs;

import java.util.ArrayList;
import java.util.PriorityQueue;

// Finding the shortest path from source to all other nodes in a weighted graph
// using Dijkstra's algorithm
// idea: the node is selected if it is source or if it has the smallest distance from the source possible
// it will help the neighbours to find the shortest path (if it can)
// now we will find the next smallest distance node (not visited yet)
// so the smallest distance it can have is the distance we have found
// now it will try to help its neighbours
// and the process continues until all nodes are visited

// we use bfs inorder to help the neighbours
// we use priority queue to get the node with the smallest distance
// as  the nodes which are updated and not visited yet will be added to the priority queue (ready to help)

// Idea: We maintain a distance array which stores the minimum distance from the source to each node.

// 1. Initialization:
//    - Create a distance array and initialize all distances to infinity, except the source node which is set to 0.
//    - Use a priority queue (min-heap) to efficiently fetch the node with the smallest distance. Push the source node into this queue.

// 2. BFS-like Traversal with Priority Queue:
//    - While the priority queue is not empty:
//      - Extract the node with the minimum distance from the queue (let's call this 'currentNode').
//      - For each neighbor of currentNode:
//        - Calculate the potential new distance from the source to this neighbor via currentNode.
//        - If this new distance is less than the currently recorded distance in the distance array:
//          - Update the distance array with the new shorter distance.
//          - Push this neighbor into the priority queue with the updated distance.

// 3. Priority Queue Logic:
//    - The priority queue ensures that the node with the smallest tentative distance is processed next.
//    - This is crucial because processing nodes in increasing order of distance guarantees that when we
//      process a node, we have already found the shortest path to it.

// 4. Termination:
//    - The algorithm terminates when the priority queue is empty, meaning all reachable nodes have been processed.
//    - The distance array now contains the shortest distances from the source to all other nodes.

public class K_Dijkstra {
    // node class for priority queue
    // it will store the node and its distance from the source
    static class node implements Comparable<node> {
        int dist;
        int node;

        node(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }

        public int compareTo(node n) {
            return this.dist - n.dist;
        }
    }

    // pair class for storing the edges of the graph
    // first is the neighbour and second is the weight of the edge from the current
    // node to the neighbour
    static class iPair {
        int first, second;

        iPair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    static ArrayList<Integer> dijkstra(ArrayList<ArrayList<iPair>> adj, int src) {
        // Write your code here
        // declaring the distance array
        ArrayList<Integer> distance = new ArrayList<>();
        for (int i = 0; i < adj.size(); i++) {
            distance.add(Integer.MAX_VALUE);
        }
        boolean[] isVisited = new boolean[adj.size()];
        // Initializing the distancearray
        // distance from source to source is 0
        distance.set(src, 0);
        // PriorityQueue
        PriorityQueue<node> pq = new PriorityQueue<>();
        pq.add(new node(src, 0));
        while (!pq.isEmpty()) {
            node cur = pq.remove();
            if (isVisited[cur.node]) {
                // if the node is already visited then skip it
                // it is possible if we added a node to the priority queue multiple times if its
                // distance was updated multiple times
                // if some node A said distance through me is 5 and some other node B said it is
                // 3
                // in both the cases we might have added the node to the priority queue
                // but the path through B is the shortest so we will visit it first
                // so after visiting it we will mark it as visited
                // if it is already visited the distance is already minimum
                // so skip the other paths
                continue;
            }
            isVisited[cur.node] = true;
            // helping the neighbours
            for (int i = 0; i < adj.get(cur.node).size(); i++) {
                iPair edgeToNeibr = adj.get(cur.node).get(i);
                // if the neighbour is not visited and the distance can be reduced
                if (!isVisited[edgeToNeibr.first]) {

                    if (distance.get(edgeToNeibr.first) > edgeToNeibr.second + distance.get(cur.node)) {
                        distance.set(edgeToNeibr.first, edgeToNeibr.second + distance.get(cur.node));
                        // we will add the node only if the distance is updated
                        // because previously it was already added with the old distance
                        // eg at the starting the distance is infinity so all nodes are added to the pq
                        // for the first time surely
                        // so now if there is a shorter path to a node then only we will add it to the
                        // pq
                        // else if we add it everytime then it will be added multiple times
                        // answer will be correct but it will be inefficient
                        pq.add(new node(edgeToNeibr.first, distance.get(edgeToNeibr.first)));
                    }
                }
            }
        }
        return distance;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<iPair>> adj = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(new iPair(1, 2));
        adj.get(0).add(new iPair(2, 4));
        adj.get(1).add(new iPair(2, 1));
        adj.get(1).add(new iPair(3, 7));
        adj.get(2).add(new iPair(4, 3));
        adj.get(3).add(new iPair(4, 1));
        // graph edges
        // 0->1 2
        // 0->2 4
        // 1->2 1
        // 1->3 7
        // 2->4 3
        // 3->4 1
        ArrayList<Integer> ans = dijkstra(adj, 0);
        System.out.println(ans);// [0, 2, 3, 9, 6]
    }
}
