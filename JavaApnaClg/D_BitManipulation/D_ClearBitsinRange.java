package D_BitManipulation;

public class D_ClearBitsinRange {
    public static void main(String[] args) {
        int n = 126; // 1111110
        int i = 3;
        int j = 5;
        // so to clear bits from i to j (3rd bit to 5th bit (excluded)) i.e to convert
        // 1111110 to 1110010 (114)
        // we can make 1110011 and then do and operation
        // inorder to make 1110011 we should perform or between 1110000 and 0000011
        // making 1110000
        int a = -1;
        int a1 = a << (j - 1);// shifting (11111111) to 4 times left
        int b = -1;
        int b1 = ~(b << (i - 1));// shifting (11111111) to 2 times left and then taking complement
        int mask = a1 | b1; // 1110011
        int ans = n & mask;
        System.out.println(ans);// 114
    }
}
