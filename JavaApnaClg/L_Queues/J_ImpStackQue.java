package L_Queues;

import java.util.Deque;
import java.util.LinkedList;

//implementing stack and queue using deque
public class J_ImpStackQue {
    static class Stack {
        static Deque<Integer> dq = new LinkedList<>();

        void push(int data) {
            dq.addLast(data);
        }

        int pop() {
            return dq.removeLast();
        }

        int peek() {
            return dq.getLast();
        }

        void print() {
            System.out.println(dq);
        }
    }

    static class Queue {
        static Deque<Integer> dq = new LinkedList<>();

        void add(int data) {
            dq.addLast(data);
        }

        int remove() {
            return dq.removeFirst();
        }

        int peek() {
            return dq.getFirst();
        }

        void print() {
            System.out.println(dq);
        }
    }

    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.pop();
        s.push(4);
        s.print();// [1, 2, 4]
        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);
        q.remove();
        q.add(4);
        q.print();// [2, 3, 4]
    }
}
