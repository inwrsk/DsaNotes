package L_Queues;

import java.util.ArrayDeque;
import java.util.Queue;
//simple approch is to use stack
import java.util.Stack;

public class H_QueReversal {
    static void reverseQueue(Queue<Integer> q) {
        Stack<Integer> s = new Stack<>();
        while (!q.isEmpty()) {
            s.push(q.remove());
        }
        while (!s.isEmpty()) {
            q.add(s.pop());
        }
    }

    public static void main(String[] args) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);
        reverseQueue(q);
        System.out.println(q);// [8, 7, 6, 5, 4, 3, 2, 1]
    }
}
