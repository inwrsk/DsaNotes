package F_Recursion;

// you are given a number n. You have to print all the binary strings of length n. 
// no two 1's are together.
// imagine there are n chairs and you have to place n people on them.
// no two boys can sit together.
// 0 means girl and 1 means boy
public class B_BinaryStrings {

    public static void printBinaryString(int nofplaces, int lastDigit, String ans) {
        if (nofplaces == 0) {
            // if there are no places left to fill
            // print the arrangement we have till now
            System.out.println(ans);
            return;
        }
        // whether the last digit is 0 or 1, we can place 0 at the current position
        printBinaryString(nofplaces - 1, 0, ans + "0");
        // after printing the arrangement with 0 at the current position remove him and place 1 if last digit is 0
        if (lastDigit == 0) {
            printBinaryString(nofplaces - 1, 1, ans + "1");
        }
    }

    public static void main(String[] args) {
        printBinaryString(3, 0, "");
    }
}
// 000 001 010 100 101