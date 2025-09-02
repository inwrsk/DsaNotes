package R_Tries;

// problem: find the longest word made of other words in the list
// i.e. if we have a list of words like ["a", "banana", "app", "appl", "ap", "apply", "apple"]
// we should select longest word made of other words in the list i.e. "apple"
// approach: insert all the words in the trie and then find the longest word
// to find the longest word we will iterate over the trie on the basis of endOfWord true
// as every prefix of the word is also a word so we will iterate over the trie and find the longest word
public class D_LongestWord {
    static class Node {
        boolean endOfWord = false;
        Node children[] = new Node[26];
    }

    static Node root = new Node();

    static void insert(String word) { // O(Length of word)
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

    static String ans = "";

    // iterate over the trie and find the longest word
    static void longestWord(Node root, StringBuilder temp) {
        if (root == null) {
            return;
        }
        // iterate over the children of the root
        for (int i = 0; i < 26; i++) {
            // if the child is not null and it is the end of the word
            if (root.children[i] != null && root.children[i].endOfWord) {
                temp.append((char) (i + 'a'));
                // if the current word is greater than the answer
                if (temp.length() > ans.length()) {
                    ans = temp.toString();
                }
                // iterate over the children of the current node
                longestWord(root.children[i], temp);
                // remove the last character
                temp.deleteCharAt(temp.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        String words[] = { "a", "banana", "app", "appl", "ap", "apply", "apple" };
        for (String word : words) {
            insert(word);
        }
        longestWord(root, new StringBuilder());
        System.out.println(ans);// apple
    }
}
