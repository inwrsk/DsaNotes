package S_Graphs;

import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

// by bfs
// idea is to push the nodes with indegree 0 to the queue
// as they are the nodes which are not dependent on any other node
// so they are eligible to be the first node
// then we will iterate through the neighbours of the current node
// and reduce the indegree of the neighbours by 1
// if the indegree of the neighbour becomes 0 then push it to the queue
// as the nodes they are dependent on are already visited and added to the result
// so they are eligible to be the next node
// so we will keep on doing this till the queue becomes empty
public class H_TopologicalSort {

    int[] topologicalSort(ArrayList<ArrayList<Integer>> graph, int[] indegree) {
        Queue<Integer> que = new LinkedList<>();
        // pushing nodes with indegree 0 to the queue
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                que.add(i);
            }
        }
        // array to be returned
        int[] res = new int[graph.size()];
        int index = 0;
        while (!que.isEmpty()) {
            int cur = que.remove();
            res[index] = cur;
            index++;
            // iterating through the neighbours of the current node
            for (int i = 0; i < graph.get(cur).size(); i++) {
                indegree[graph.get(cur).get(i)] -= 1;
                if (indegree[graph.get(cur).get(i)] == 0) {
                    // if the indegree of the neighbour becomes 0 then push it to the queue
                    que.add(graph.get(cur).get(i));
                }
            }
        }
        return res;
    }

    boolean byDfs(ArrayList<ArrayList<Integer>> graph, boolean[] isVisited1, boolean isVisited2[], int cur) {
        isVisited1[cur] = true;
        isVisited2[cur] = true;
        for (int i = 0; i < graph.get(cur).size(); i++) {
            if (!isVisited1[graph.get(cur).get(i)]) {// instead of isVisited2 we can use isVisited1
                // if we use visited2 then it will go through the nodes which are previously
                // visited
                // so more time complexity
                boolean tempRes = byDfs(graph, isVisited1, isVisited2, graph.get(cur).get(i));
                if (tempRes) {
                    return true;
                }
            } else {// if the node is visited already in some other path
                if (isVisited2[graph.get(cur).get(i)]) {// if we are visiting it again in the current path
                    return true;
                }
            }
        }
        isVisited2[cur] = false;// while coming back unmark the node as visited
        return false;
    }

    boolean CycleExists(ArrayList<ArrayList<Integer>> graph) {
        // we will detect if cycle by using dfs
        // maitain isVisited array
        // if we get a visited node then cycle exists
        boolean isVisited1[] = new boolean[graph.size()];
        for (int i = 0; i < graph.size(); i++) {
            if (!isVisited1[i]) {
                boolean tempRes = byDfs(graph, isVisited1, new boolean[graph.size()], i);
                if (tempRes) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        int n = 6;
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        graph.get(5).add(2);
        graph.get(5).add(0);
        graph.get(4).add(0);
        graph.get(4).add(1);
        graph.get(2).add(3);
        graph.get(3).add(1);
        // Diagram of the graph
        // 5 -> 2
        // 5 -> 0
        // 4 -> 0
        // 4 -> 1
        // 2 -> 3
        // 3 -> 1
        // .>2--->3
        // /...../.\
        // 5....4--->1
        // \.../
        // .>0<

        int[] indegree = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < graph.get(i).size(); j++) {
                indegree[graph.get(i).get(j)] += 1;
            }
        }
        H_TopologicalSort obj = new H_TopologicalSort();
        if (obj.CycleExists(graph)) {
            System.out.println("Cycle Exists");
            return;
        }
        int[] res = obj.topologicalSort(graph, indegree);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");// 4 5 2 0 3 1
        }
    }
}
