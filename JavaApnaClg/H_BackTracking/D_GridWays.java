package H_BackTracking;

//you are at starting position x1,y1 and your target position is x2,y2
// you can move either right or down
//find the no of ways you can reach the target?
public class D_GridWays {
    static int findWays(int x1, int y1, int x2, int y2) {
        if (x1 > x2 || y1 > y2) {
            return 0;
        }
        if (x1 == x2 && y1 == y2)
            return 1;
        // ways after moving down // ways after moving right
        return findWays(x1 + 1, y1, x2, y2) + findWays(x1, y1 + 1, x2, y2);
    }
    // the time complexity is worst 2^(n+m) where n = x2-x1 (no of downsteps D) and
    // m = y2 - y1 (R right steps)
    // optimized code contains simple math formula
    // if we analyze every path that is possible there will be nD's and mR's in a
    // path like down down right right etc..
    // total no of ways to reach is the permutation of these directions
    // total ways = n+m!/n!*m! (rearranging the D's and R's will give a new path)

    public static void main(String[] args) {
        int x1 = 0;
        int y1 = 0;
        int x2 = 2;
        int y2 = 2;
        System.out.println("no of ways : " + findWays(x1, y1, x2, y2));
    }
}
