package Q_Hashing;

import java.util.*;

// Given two strings a and b, return true if they are anagrams of each other, and false otherwise.
// anagram is two strings that are permutations of each other
// approach: create a hashmap and store the frequency of each character of string a and b
public class G_IsAnagram {
    public static boolean isAnagram(String a, String b) {
        if (a.length() != b.length())
            return false;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < a.length(); i++) {
            Character c = a.charAt(i);
            Character d = b.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
            map.put(d, map.getOrDefault(d, 0) - 1);
            // if the frequency of any character is 0, remove it from the map
            if (map.getOrDefault(c, 0) == 0) {
                map.remove(c);
            }
            if (map.getOrDefault(d, 0) == 0) {
                map.remove(d);
            }
        }
        return map.size() == 0;
    }

    public static void main(String[] args) {
        String a = "listen";
        String b = "silent";
        System.out.println(isAnagram(a, b));// true
    }
}
