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
// so for that we can use DFS (for all the components) and store the paths
// another thing is if there is a path from A to H and if we selected C as the src at first the initial path will be c->d->e->f->g->h
// and at the moment we know that there is no other node exists we comes after c, whatever the nodes which are after c are already added
// what we don't know is the nodes which are before c
// so lets assume there is path from A to B before c and the path is A->B
// so and there is a path parallel to c->h which is 1->6, which we can add after teh c->h or before c->h or in between c->h
// if we have path like A->B which is before c then we can add it before c->h
// so the common thing between any path is to add the nodes before the existing path so that there will be no conflict
// so the safe option is to add the newly found path before the existing path and soon all the paths will be merged
// so the final answer will be the merged path
// for that we use DFS and add the nodes to it from teh leaf node to the src node (which is the reverse of the path)
// and join all the paths to the same arrayList 
// and finally reverse the arrayList to get the answer
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

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        // graph = [[1, 2], [3], [3], []] //ans = [0, 1, 2, 3] or [0, 2, 1, 3]
        for (int i = 0; i < 4; i++) {
            graph.add(new ArrayList<>());
        }
        graph.get(0).add(1);
        graph.get(0).add(2);
        graph.get(1).add(3);
        graph.get(2).add(3);
        ArrayList<Integer> ans = topologicalSort(graph);
        System.out.println(ans);// [0, 2, 1, 3]
    }
}
