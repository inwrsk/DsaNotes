package S_Graphs;

import java.util.ArrayList;
import java.util.List;

// by dfs
// this will print the paths from source (0) to the target (n-1) lastnode
// the idea is to traverse the graph by dfs and keep on adding the nodes to the path
// if we reach the last node then we have found the path so add it to the final ans
public class I_allPathsSrcToTarget {// tested code
    // traversing the graph by dfs with arguments graph, final ans, temporary path,
    // current node
    List<List<Integer>> byDFS(int[][] graph, List<List<Integer>> ans, List<Integer> temp, int src) {
        // add current node to the current path
        temp.add(src);
        // if the current node is the last node
        if (src == graph.length - 1) {
            // then we have found the path to last node so create a new arrayList same as
            // the path and add to the final ans
            ArrayList<Integer> newtemp = new ArrayList<>();
            for (int i = 0; i < temp.size(); i++) {
                newtemp.add(temp.get(i));
            }
            ans.add(newtemp);
            // and remove the last node of the temp path ArrayLIst for moving on to the next
            // neighbour (for exploring new path)
            temp.remove(temp.size() - 1);
            return ans;
        }
        // if it was not the last node then iterate all the neighbours and try out new
        // paths
        for (int i = 0; i < graph[src].length; i++) {
            int neighbour = graph[src][i];
            byDFS(graph, ans, temp, neighbour);
        }
        // after trying the current node remove it from the current path
        // to explore from the perspective of its sibling (new paths)
        temp.remove(temp.size() - 1);
        return ans;
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        return byDFS(graph, new ArrayList<>(), new ArrayList<>(), 0);
    }

    public static void main(String[] args) {
        I_allPathsSrcToTarget obj = new I_allPathsSrcToTarget();
        int[][] graph = { { 1, 2 }, { 3 }, { 3 }, {} };
        // phyical representation of the graph
        // ......0
        // ...../ \
        // ....v...v
        // ....1...2
        // .....\ /
        // ......v
        // ......3
        List<List<Integer>> ans = obj.allPathsSourceTarget(graph);
        for (int i = 0; i < ans.size(); i++) {
            for (int j = 0; j < ans.get(i).size(); j++) {
                System.out.print(ans.get(i).get(j) + " ");
                // 0 1 3
                // 0 2 3
            }
            System.out.println();
        }
    }
}
