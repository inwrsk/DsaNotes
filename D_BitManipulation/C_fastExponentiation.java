package D_BitManipulation;

// Fast Exponentiation instead of O(n) it is O(log(n))

public class C_fastExponentiation {
    // log(n)
    public static void main(String[] args) {

        // calculating a power n
        // 2 power 10 == 2^(8+ 0 + 2 + 0) (1010)
        // 2^8 * 2^2;
        // i.e we have to add only when the bits are 1
        // idea:
        // iterate k times where k is the number of bits in n meanwhile calculate the a powers 
        // i.e a^1, a^2, a^4, a^8, a^16, a^32, a^64, a^128, a^256, a^512
        // why this is required ? because we use them to calculate the answer
        // if the bit is 1 then multiply the answer with the corresponding power of a at the moment
        // if the bit is 0 then do nothing

        Integer a = 2;
        Integer n = 10;
        Integer ans = 1;
        while (!n.equals(0)) {
            if (Integer.valueOf(n%2).equals(1)) {// also by (n&1) == 1
                ans *= a;
            }
            n = n >> 1;// n = n/2
            a = a * a;
        }
        System.out.println(ans);// 1024
    }

}
