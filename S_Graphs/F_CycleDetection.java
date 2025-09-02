package S_Graphs;

import java.util.ArrayList;

// Detecting cycle in Directed Graph
// DFS O(V+E)
public class F_CycleDetection {// Tested Code *
    // for iterating through every component
    static boolean DetectGlobally(ArrayList<ArrayList<Integer>> graph) {
        // global tracking
        boolean isVisitedG[] = new boolean[graph.size()];
        // local tracking
        boolean isVisitedL[] = new boolean[graph.size()];
        // going through every component Detect locally if they weren't yet!
        for (int i = 0; i < graph.size(); i++) {
            if (!isVisitedG[i]) {
                if (DetectLocally(graph, isVisitedG, isVisitedL, i)) {
                    // if cycle found
                    return true;
                }
            }
        }
        // if no cycle found in any of the component
        return false;
    }

    // for going through every node in a component
    static boolean DetectLocally(ArrayList<ArrayList<Integer>> graph, boolean isVisitedG[], boolean isVisitedL[],
            int Node) {
        isVisitedG[Node] = true;// Marking globally
        isVisitedL[Node] = true;// Marking locally
        // going to every neighbour
        for (int neighbour : graph.get(Node)) {
            // if they are not visited yet
            if (!isVisitedL[neighbour]) {
                // search locally with respect to them and return true if they found a cycle
                if (DetectLocally(graph, isVisitedG, isVisitedL, neighbour)) {
                    return true;
                }
            } else {// if they are already visited cycle exists
                return true;
            }
        }
        // while coming back (back tracking remove the mark) as searching this current
        // path has ended
        // and won't be a disturbance while going through this node on another path (no
        // confusion)
        isVisitedL[Node] = false;
        return false;
    }
}
