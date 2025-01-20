package S_Graphs;

import java.util.ArrayList;

public class A_Graph {
    public static void main(String[] args) {
        // .........5
        // .....(0)----(1)
        // ............/.\
        // ..........1/...\3
        // ........../.....\
        // ........(2)-----(3)
        // .........|...1
        // ........2|
        // .........|
        // ........(4)
        // STORING METHOD : ADJACENCY LIST
        // for every vertex we will store edges from it
        int vertices = 5;
        // graph is array of arraylists of edges for vertices
        // declaration
        @SuppressWarnings("unchecked")
        ArrayList<A_Edge>[] graph = new ArrayList[vertices];// all the values need to be intiated as they are null now
        // initiation
        for (int i = 0; i < vertices; i++) {
            graph[i] = new ArrayList<>();
        }

        // vertex 0
        graph[0].add(new A_Edge(0, 1, 5));
        // vertex 1
        graph[1].add(new A_Edge(1, 0, 1));
        graph[1].add(new A_Edge(1, 2, 1));
        graph[1].add(new A_Edge(1, 3, 3));
        // vertex 2
        graph[2].add(new A_Edge(2, 1, 1));
        graph[2].add(new A_Edge(2, 3, 1));
        graph[2].add(new A_Edge(2, 4, 2));
        // vertex 3
        graph[3].add(new A_Edge(3, 1, 3));
        graph[3].add(new A_Edge(3, 2, 1));
        // vertex 4
        graph[4].add(new A_Edge(4, 2, 2));
        // printing neighbours of every vertex in graph
        System.out.println("neighbours of every vertex : ");
        for (int i = 0; i < graph.length; i++) {
            System.out.println("vertex : " + i);
            for (int j = 0; j < graph[i].size(); j++) {
                System.out.print(graph[i].get(j).dest + " ");
            }
            System.out.println();
        }
    }
}
