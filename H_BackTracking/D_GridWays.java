package H_BackTracking;

// you are at starting position x1,y1 and your target position is x2,y2
// you can move either right or down
// find the no of ways you can reach the target?

public class D_GridWays {
    static Integer findWays (Integer x1, Integer y1, Integer x2, Integer y2) {
        if (x1 > x2 || y1 > y2) {
            return 0;
        }
        if (x1.equals(x2) && y1.equals(y2))
            return 1;
        // ways after moving down // ways after moving right
        return findWays(x1 + 1, y1, x2, y2) + findWays(x1, y1 + 1, x2, y2);
    }

    // the time complexity is worst 2^(n+m) where n = x2-x1 (no of downsteps D) and m = y2 - y1 (R right steps)
    // 2 because two function calls, if there are 3 function calls then it may be 3^(n+m)
    // optimized code contains simple math formula
    // if we analyze every path that is possible there will be nD's and mR's in a
    // path like down down right right etc..
    // total no of ways to reach is the permutation of these directions
    // total ways = (n+m)!/n!*m! (rearranging the D's and R's will give a new path)
    // or using the formula arr[x][y] = arr[x-1][y] + arr[x][y-1] i.e answer via left + answer via top using dp

    public static void main(String[] args) {
        Integer x1 = 0;
        Integer y1 = 0;
        Integer x2 = 2;
        Integer y2 = 2;
        System.out.println("no of ways : " + findWays(x1, y1, x2, y2));//6
    }
}
