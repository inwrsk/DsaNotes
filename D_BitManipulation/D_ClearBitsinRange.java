package D_BitManipulation;
// just for info : 1 byte = 8 bits ==> xxxx xxxx
public class D_ClearBitsinRange {
    public static void main(String[] args) {
        Integer n = 126; // 0111 1110
        Integer i = 3;
        Integer j = 5;
        // so to clear bits from i to j (3rd bit to 5th bit (excluded)) i.e to convert
        // 0111 1110 to 0111 0010 (114)
        // we can make 1111 0011 and then do and operation with the given number
        // inorder to make 1111 0011 we should perform or between 1111 0000 and 0000 0011
        // making 1111 0000 (idea :  shifting (1111 1111) to 4 times left)
        Integer a = -1; // 1111 1111
        Integer a1 = a << (j - 1);
        // making of 0000 0011 (it looks like negation of 1111 1100 right! and to prepare this thing follow the above process again)
        Integer b = -1;
        Integer b1 = ~(b << (i - 1));// shifting (1111 1111) to 2 times left and then taking complement
        Integer mask = a1 | b1; // 1111 0011
        Integer ans = n & mask; // 0111 1110 & 1111 0011 => 0111 0010 
        System.out.println(ans);// 114
    }
}
