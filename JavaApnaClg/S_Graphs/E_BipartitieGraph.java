package S_Graphs;

import java.util.*;

// check whether the given graph is bipartitie or not
public class E_BipartitieGraph {
    // tested !!
    // input is a adjacency list array of array of nodes connected to a node
    public static boolean isBipartite(int[][] graph) {
        // array that maintains the set every node belongs
        int[] setOfNode = new int[graph.length];// by default set every node belongs to is 0
        // and the sets we are going to assign are 1, -1
        // queue used for bfs
        Queue<Integer> que = new LinkedList<>();
        // iterating over graph to find disconnected components
        for (int i = 0; i < graph.length; i++) {
            // if we find one of the disconnected component
            if (setOfNode[i] == 0) {// if set was not yet assigned == unvisted
                setOfNode[i] = 1;
                que.add(i);
                // explore the neighbours of it
                while (!que.isEmpty()) {
                    Integer curNode = que.remove();
                    // iterate over the neighbours and assign them the opposite set "-1 or 1"
                    for (int j = 0; j < graph[curNode].length; j++) {
                        if (setOfNode[graph[curNode][j]] == 0) {// if the current neighbour unvisited
                            que.add(graph[curNode][j]);
                            setOfNode[graph[curNode][j]] = -1 * setOfNode[curNode];// assigning opposite set
                        } else {
                            if (setOfNode[graph[curNode][j]] == setOfNode[curNode]) {// if the neighbour also belongs to
                                                                                     // same set
                                System.out.println(curNode + " " + graph[curNode][j]);
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}
