package F_Recursion;

// you are given a number n. You have to print all the binary strings of length n. 
// no two 1's are together.
public class B_BinaryStrings {

    public static void printBinaryString(int nofplaces, int lastDigit, String ans) {
        if (nofplaces == 0) {
            System.out.println(ans);
            return;
        }
        printBinaryString(nofplaces - 1, 0, ans + "0");
        if (lastDigit == 0) {
            printBinaryString(nofplaces - 1, 1, ans + "1");
        }
    }

    public static void main(String[] args) {
        printBinaryString(3, 0, "");
    }
}
// 000 001 010 100 101