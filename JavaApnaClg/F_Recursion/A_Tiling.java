package F_Recursion;

//you are given a floor of size 2xN. you have tiles of size 2x1. Find the number of ways to place the tiles on the floor.

public class A_Tiling {
    public static void main(String[] args) {
        System.out.println(tiling(3));// 1_1_1, 1_2, 2_1 (3 ways)
    }

    public static int tiling(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return tiling(n - 1) + tiling(n - 2);
    }
}