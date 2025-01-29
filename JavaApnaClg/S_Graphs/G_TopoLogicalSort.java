package S_Graphs;

import java.util.ArrayList;
import java.util.Collections;

// Problem : Topological Sort
// Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering of vertices such that for every directed edge u v, vertex u comes before v in the ordering. Topological Sorting for a graph is not possible if the graph is not a DAG. 
// eg: 
// graph = [[1, 2], [3], [3], []]
// in diagram form:
// 0->1->3
//  \   /
//   >2>
// Topological Sort: [0, 1, 2, 3]
// Topological Sort: [0, 2, 1, 3]
// any of the above can be the answer
// so the answer is not unique
// idea: 
// so if there is a path from src to dest then  in  the final answer all the nodes will follow the same order the path follows
// so if we get all the paths and merge them we will get the answer 
// note : the paths can be in any order
// but the nodes in the path should be in the same order as the path
// so for that we can use DFS (for all the components) and store the nodes
// see a lecture for better understanding
public class G_TopoLogicalSort {
    // for going through the components
    static ArrayList<Integer> topLogSort(ArrayList<ArrayList<Integer>> graph) {
        ArrayList<Integer> ans = new ArrayList<>();
        boolean isVisited[] = new boolean[graph.size()];
        for (int i = 0; i < graph.size(); i++) {
            if (!isVisited[i]) {
                DFSUtil(graph, isVisited, i, ans);
            }
        }
        return ans;
    }

    // for going through the nodes in a component
    static void DFSUtil(ArrayList<ArrayList<Integer>> graph, boolean[] isVisited, int i, ArrayList<Integer> ans) {
        isVisited[i] = true;
        for (int j : graph.get(i)) {
            if (!isVisited[j]) {
                DFSUtil(graph, isVisited, j, ans);
            }
        }
        ans.add(i);
    }

    static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> ans = topLogSort(adj);
        Collections.reverse(ans);
        return ans;// TESTED CODE
    }
}
