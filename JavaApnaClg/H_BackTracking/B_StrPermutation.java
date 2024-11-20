package H_BackTracking;

//to print all the permutations or arrangements of the string 

public class B_StrPermutation {
    // takes the string that permutation has been left , (for selecting chars from
    // it)
    // current string (that has been permutated till now) (to add the selected
    // chars)
    // and the length of original string (to stop the iteration after our ans
    // reaches the full length)
    public static void prtPermutation(String s, String ans, int length) {
        if (ans.length() == length) {
            System.out.println("\"" + ans + "\"");
        }
        // trying a permutaion if ith char is selected first (or placed first)
        for (int i = 0; i < s.length(); i++) {
            String str = s.substring(0, i) + s.substring(i + 1, s.length());
            prtPermutation(str, ans + s.charAt(i), length);
            // after trying ith char we try for i+1th char
        }
    }

    public static void main(String[] args) {
        String s = "abcd";
        prtPermutation(s, "", s.length());
    }
}
// "abc"
// "acb"
// "bac"
// "bca"
// "cab"
// "cba"