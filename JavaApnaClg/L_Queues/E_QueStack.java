package L_Queues;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class E_QueStack {
    static class Stack {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new ArrayDeque<>();

        // isEmpty
        boolean isEmpty() {
            return q1.isEmpty() && q2.isEmpty();
        }

        // push O(1)
        void push(int data) {
            if (q1.isEmpty()) {
                q2.add(data);
            } else {
                q1.add(data);
            }
        }

        // pop O(n)
        // take the last one inthe queue while passin from one queue to another
        int pop() {
            if (isEmpty()) {
                System.out.println("stack is empty");
                return Integer.MIN_VALUE;
            }
            Queue<Integer> curQue = q1;
            Queue<Integer> othQue = q2;
            if (q1.isEmpty()) {
                curQue = q2;
                othQue = q1;
            }
            int elem = Integer.MIN_VALUE;
            while (!curQue.isEmpty()) {
                elem = curQue.remove();
                if (curQue.isEmpty()) {
                    break;
                }
                othQue.add(elem);
            }
            return elem;
        }

        // peek O(n)
        int peek() {
            int elem = pop();
            push(elem);
            return elem;
        }
    }

    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        while (!s.isEmpty()) {
            System.out.println(s.peek());// 3 2 1
            s.pop();
        }
        s.pop();// stack is empty
        s.push(23);
        System.out.println(s.peek());// 23
    }
}
