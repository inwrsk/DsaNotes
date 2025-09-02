package P_Heaps;

import java.util.PriorityQueue;

// we have to find the k closest points to the origin
// gen approach is to find the distance of each point from the origin
// sort the points based on the distance
// return the first k points
public class D_KNearestPts {
    static class point implements Comparable<point> {
        int coor[] = new int[2];
        int distance;

        point(int x, int y) {
            this.distance = x * x + y * y;
            coor[0] = x;
            coor[1] = y;
        }

        @Override
        public int compareTo(point p) {
            return this.distance - p.distance;
        }
    }

    public static int[][] kClosest(int[][] points, int k) {
        // we will priority queue for getting sorted points based on distance
        PriorityQueue<point> pq = new PriorityQueue<>();
        for (int i = 0; i < points.length; i++) {
            pq.add(new point(points[i][0], points[i][1]));
        }
        int res[][] = new int[k][2];
        for (int i = 0; i < k; i++) {
            res[i] = pq.remove().coor;
        }
        return res;
    }

    public static void main(String[] args) {
        int points[][] = { { 3, 3 }, { 5, -1 }, { -2, 4 } };
        int k = 2;
        int res[][] = kClosest(points, k);
        for (int i = 0; i < res.length; i++) {
            System.out.println("{" + res[i][0] + ", " + res[i][1] + "}");
            // {3, 3}
            // {-2, 4}
        }
    }
}