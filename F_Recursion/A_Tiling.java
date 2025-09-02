package F_Recursion;

//you are given a floor of size 2xN. you have tiles of size 2x1. Find the number of ways to place the tiles on the floor.
// imagine the floor as a chessboard 2XN like a big rectangle
// imagine tile as a small rectangle 2X1
// you have to place the tiles on the floor such that no tile should overlap.
public class A_Tiling {
    public static void main(String[] args) {
        System.out.println(tiling(3));// 1_1_1, 1_2, 2_1 (3 ways)
    }

    public static int tiling(int n) {
        if (n == 0) {// if there are no space in the floor then there is no way to place the tile
            return 0;
        }
        if (n == 1) {// if there is only 1 tile space left on the floor then there is only 1 way to place the tile
            return 1;
        }
        if (n == 2) {// if there are 2 tile space left on the floor then there are 2 ways to place the tile
            // 1. place 2 tiles horizontally
            // 2. place 2 tiles vertically
            // so there are 2 ways to place the tile
            return 2;
        }
        // if there are n tiles space left on the floor then there are 2 ways to place the tile
        // 1st way place the tile vertically (i.e fill in such a way that 2 borders are fully attached between floor and tile )
        // 2nd way place two tiles horizontally (i.e fill in such a way that bottom border and upper border of tile 1 and tile 2 are attached to bottom and upper border of the floor respectively)
        // and calculate the rest of the ways recursively

        return tiling(n - 1) + tiling(n - 2);
    }
}