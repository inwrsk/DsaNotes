package H_BackTracking;

// To find all the subsets of strings
public class A_AllSubsetsOfStr {
    public static void printSubsets(String s, int pos, String ans) {
        if (pos == s.length()) {
            System.out.println("\"" + ans + "\"");
            return;
        }
        printSubsets(s, pos + 1, ans);// if the particular char is not selected
        printSubsets(s, pos + 1, ans + s.charAt(pos));// if the char is selected
    }

    public static void main(String[] args) {
        String s = "abc";
        // s is original string, pos is where we have completed till now , ans: till now
        // which elements we have selected
        printSubsets(s, 0, "");
    }
}
// ""
// "c"
// "b"
// "bc"
// "a"
// "ac"
// "ab"
// "abc"