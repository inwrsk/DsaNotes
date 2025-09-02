package R_Tries;

// approach: find all the substrings and put them in a trie
// you will get n nodes in trie i.e n unique substrings possible and + 1 empty string and it is the answer n(nodes)+1
// one of the method to to get all the substrings is prefixes of suffixes or suffixes or prefixes of given string
// inserting via prefixes of suffixes into trie is better 
// cz if we insert a String to trie automacally we have added all the prefixes of it
// so first iterate over the string and add all the suffixes to the trie
// and then return total nodes
public class C_DistinctSubStrings {
    static class Node {
        Node children[] = new Node[26];
        int nodes = 1;
    }

    static class Trie {
        Node root = new Node();

        // i=starting point of the string to be inserted, s = string, root = node to be
        // inserted
        int insert(int i, String s, Node root) {
            if (i == s.length()) {
                return 0;
            }
            Node curr = root;
            int idx = s.charAt(i) - 'a';
            int isAdded1 = 0;
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
                isAdded1 = 1;
            }
            // return 1(if any new node created this stage) + no of nodes created for
            // remaining part
            return isAdded1 + insert(i + 1, s, curr.children[idx]);
        }
    }

    public static int countDistinctSubstring(String s) {
        Trie t = new Trie();
        // finding suffixes and inserting in the trie
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            // inserting all the suffixes to the trie
            // it will return how many new nodes have been created
            ans += t.insert(i, s, t.root);
        }
        return ans + 1;
    }

    public static void main(String[] args) {
        String s = "ababa";
        System.out.println(countDistinctSubstring(s));// 10
    }
}
