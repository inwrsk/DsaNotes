package D_BitManipulation;

public class B_shifts {
    public static void main(String[] args) {
        // left shift
        System.out.println(3 << 2);// 12 (11 => 1100) shifted 2 places to left
        // right shift
        System.out.println(3 >> 1);// 1 (formula 3/2power1)
        // 11 -> 1 (1)
        System.out.println(-6 >> 1);// -3
        //    -6            -3
        // 1111 1010 => 1111 1101 i.e (-) 0000 0010 + 1 => -3
        System.out.println(5 >> 1 << 1); // 4
        // Executes left to right
        // 5 becomes 2 then 4
    }
}