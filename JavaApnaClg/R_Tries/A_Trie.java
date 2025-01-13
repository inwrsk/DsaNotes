package R_Tries;

public class A_Trie {
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

    static boolean search(String word) {// O(length of word)
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx];
        }
        return curr.endOfWord == true;
    }

    public static void main(String[] args) {
        String[] words = { "the", "a", "there", "their", "any", "thee" };
        for (String i : words) {
            insert(i);
        }

        System.out.println(search("thei"));// false
        System.out.println(search("the"));// true
        System.out.println(search("amy"));// false
    }
}
