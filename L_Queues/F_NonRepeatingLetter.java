package L_Queues;

import java.util.LinkedList;
import java.util.Queue;

//we have to find the first non repeating character in the string till now(current index)
public class F_NonRepeatingLetter {
    static void printNonRepeating(String str) {
        // to track the no of appereaces of a-z
        int[] map = new int[26];
        // to push the characters from current nonRepeatingChar to curr index (available
        // for checking)
        // when cur nRC no longer a nRC
        Queue<Character> q = new LinkedList<>();
        // iterating through the string to push char into queue and track the
        // repetations
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            map[c - 97]++;
            q.add(c);
            // repeat till we find the worthy candidate
            while (!q.isEmpty() && map[q.peek() - 97] != 1) {
                q.remove();
            }
            // if we not found one => -1
            if (q.isEmpty()) {
                System.out.print("-1 ");
            } // we found
            else {
                System.out.print(q.peek() + " ");
            }
        }
    }

    public static void main(String[] args) {
        String str = "aabccxb";
        printNonRepeating(str);
    }
}
