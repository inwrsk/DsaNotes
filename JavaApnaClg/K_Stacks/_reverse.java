package K_Stacks;

import java.util.Stack;

public class _reverse {
    static String reverseString(String str) {
        Stack<Character> s = new Stack<>();
        int idx = 0;
        while (idx < str.length()) {
            s.push(str.charAt(idx));
            idx++;
        }
        StringBuilder newStr = new StringBuilder();
        while (!s.isEmpty()) {
            newStr.append(s.pop());
        }
        return newStr.toString();
    }

    // remove the top element
    // reverse the stack
    // push the element at bottom
    static void reverseStack(Stack<Integer> s) {
        if (s.isEmpty()) {
            return;
        }
        int top = s.pop();
        reverseStack(s);
        _pushAtBottom.pushAtBottom(s, top);
    }

    public static void main(String[] args) {
        String str = "anwar";
        System.out.println("original string : " + str);
        System.out.println("reversed string : " + reverseString(str));
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        System.out.println(s);// [1, 2, 3, 4]
        reverseStack(s);
        System.out.println(s);// [4, 3, 2, 1]
    }
}
