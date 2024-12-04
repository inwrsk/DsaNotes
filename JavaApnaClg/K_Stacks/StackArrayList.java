package K_Stacks;

import java.util.ArrayList;

public class StackArrayList {
    ArrayList<Integer> list = new ArrayList<>();

    boolean isEmpty() {
        return list.size() == 0;
    }

    // add the element on top of the stack
    void add(int data) {
        list.add(data);
    }

    // remove the element and return teh value
    int pop() {
        if (isEmpty()) {
            return Integer.MIN_VALUE;
        }
        int data = list.get(list.size() - 1);
        list.remove(list.size() - 1);
        return data;
    }

    // return the element at the top
    int peek() {
        if (isEmpty()) {
            return Integer.MIN_VALUE;
        }
        return list.get(list.size() - 1);
    }

    public static void main(String[] args) {
        StackArrayList stk = new StackArrayList();
        stk.add(0);
        stk.add(1);
        stk.add(2);
        stk.add(3);
        while (!stk.isEmpty()) {
            System.out.println(stk.peek());
            stk.pop();
        }
    }
}