package S_Graphs;

public class A_Edge {
    int src;
    int dest;
    int wt;

    A_Edge(int src, int dest, int wt) {
        this.src = src;
        this.dest = dest;
        this.wt = wt;
    }

    A_Edge(int dest) {
        this.dest = dest;
    }

    A_Edge(int src, int dest) {
        this.src = src;
        this.dest = dest;
    }
}
