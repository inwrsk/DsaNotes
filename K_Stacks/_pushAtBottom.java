package K_Stacks;

import java.util.Stack;

public class _pushAtBottom {
    // remove all the elements and push the data
    // again place them
    static void pushAtBottom(Stack<Integer> s, int data) {
        if (s.isEmpty()) {
            s.push(data);
            return;
        }
        // removing the first elemt
        int top = s.pop();
        // sending data to place at bottom
        pushAtBottom(s, data);
        // after placing at bottom placing top element again
        s.push(top);
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        System.out.println(s);// [1, 2, 3]
        pushAtBottom(s, 0);
        System.out.println(s);// [0, 1, 2, 3]
    }
}
