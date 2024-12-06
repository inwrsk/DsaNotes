package L_Queues;

import java.util.Stack;

public class D_StackQue {
    static class Que {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        // remove operation
        int remove() {
            if (s1.isEmpty()) {
                System.out.println("Queue is empty");
                return Integer.MIN_VALUE;
            }
            return s1.pop();
        }

        // peek operation
        int peek() {
            if (s1.empty()) {
                System.out.println("queue is empty");
                return Integer.MIN_VALUE;
            }
            return s1.peek();
        }

        // add operation
        // before adding something at the bottom of a bucket empty the bucket
        // push the element and then refill the bucket
        void add(int data) {// O(n)
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
            s1.push(data);
            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
        }

        boolean isEmpty() {
            return s1.isEmpty();
        }
    }

    public static void main(String[] args) {
        Que q = new Que();
        q.add(1);
        q.add(2);
        q.add(3);
        while (!q.isEmpty()) {
            System.out.println(q.peek());// 1 2 3
            q.remove();
        }
        q.remove();// Queue is empty
        q.add(10);
        System.out.println(q.peek());// 10
    }
}
