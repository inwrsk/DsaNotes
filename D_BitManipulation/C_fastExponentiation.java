package D_BitManipulation;

public class C_fastExponentiation {
    // log(n)
    public static void main(String[] args) {
        // calculating a power n
        // 2 power 10 == 2^(8+ 0 + 2 + 0) (1010)
        // 2^8 * 2^2;
        int a = 2;
        int n = 10;
        int ans = 1;
        while (n != 0) {
            if (n % 2 == 1) {// also by n&1 == 1
                ans *= a;
            }
            n = n >> 1;
            a = a * a;
        }
        System.out.println(ans);
    }

}
