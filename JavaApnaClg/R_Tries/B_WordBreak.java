package R_Tries;

import java.util.*;

// problem : find if the string can be broken into words from the dictionary
// approach : trie
// time complexity : O(n^2)
// approch : recursive
// first take one string and check if it is in the trie
// if it is then check for the other part of the string
// if the other part is also in the trie then return true
// else take another string at the start and proceed accourdingly
public class B_WordBreak {
    // node for trie
    static class Node {
        Node[] children = new Node[26];
        boolean endOfWord = false;
    }

    static class Trie {
        Node root = new Node();

        Trie(List<String> wordDict) {
            // insert every string into trie
            for (String s : wordDict) {
                // index from where to start, string, where to push
                push(s, root);
            }
        }

        void push(String word, Node root) {
            Node curr = root;
            for (int i = 0; i < word.length(); i++) {
                int idx = word.charAt(i) - 'a';
                if (curr.children[idx] == null) {
                    curr.children[idx] = new Node();
                }
                curr = curr.children[idx];
            }
            curr.endOfWord = true;
        }
    }

    // from where to start searching in tree, what to search, where to search
    static boolean search(String s, Node root) {
        // if there are chars to search for
        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            root = root.children[idx];
            if (root == null) {
                return false;
            }
            // if it is the last char of the string
            if (i == s.length() - 1) {
                return root.endOfWord == true;
            }
        }
        // if there is nothing to search for (empty string)
        return true;
    }

    static boolean check(String s, Node t) {
        // if only one char exists search for it and return the result
        if (s.length() == 0) {
            return true;
        }
        // if more than one char exists
        for (int i = 1; i <= s.length(); i++) {
            // if the substring exists
            if (search(s.substring(0, i), t)) {
                boolean otherpart = check(s.substring(i, s.length()), t);
                // and also the other part exists then
                if (otherpart) {
                    return true;
                }
            }
        }
        // ans don't exist
        return false;
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        Trie t = new Trie(wordDict);
        return check(s, t.root);
    }

    public static void main(String[] args) {
        // true
        // String s = "catsandog";
        // String[] str = { "cats", "dog", "sand", "and", "cat" };
        // false (takes long time) (correct approch is dynamic programming)
        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
        String[] str = { "a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa",
                "aaaaaaaaaa" };
        ArrayList<String> wordDict = new ArrayList<>();
        Collections.addAll(wordDict, str);
        System.out.println(wordBreak(s, wordDict));
    }
}
