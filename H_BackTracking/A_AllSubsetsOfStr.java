package H_BackTracking;
// To find all the subsets (Not Permutations only combinations) of strings
public class A_AllSubsetsOfStr {
    // some order not lexicographical
    public static void printSubsets(String s, Integer pos, String ans) {
        if (pos.equals(s.length())) {
            System.out.println("\"" + ans + "\"");
            return;
        }
        printSubsets(s, pos + 1, ans);// if the particular char is not selected
        printSubsets(s, pos + 1, ans + s.charAt(pos));// if the char is selected
    }
    // if you want them in lexicographical order (if string is in order)
    static void printSubsets2(String s, String temp, Integer pos){
        System.out.println("\"" + temp + "\"");
        for(Integer i = pos;i<s.length();i++){
            printSubsets2(s, temp + s.charAt(i), i+1);
        }
    }

    public static void main(String[] args) {
        String s = "abc";
        // s is original string, pos is where we have completed till now , ans: till now
        // which elements we have selected
        System.out.println("output 1");
        printSubsets(s, 0, "");// output 1
        System.out.println("output 2");
        printSubsets2(s, "", 0);
    }
}
// output 1
// ""
// "c"
// "b"
// "bc"
// "a"
// "ac"
// "ab"
// "abc"
// output 2
// ""
// "a"
// "ab"
// "abc"
// "ac"
// "b"
// "bc"
// "c"
