package L_Queues;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

//head is front tail is rear
public class C_LLQueue {
    static class Que {

        static class Node {
            int data;
            Node next;

            Node(int data) {
                this.data = data;
                this.next = null;
            }
        }

        // we declared it as private so that instances can't access them
        private Node head;
        private Node tail;

        boolean isEmpty() {
            return head == null && tail == null;
        }

        // add it on tail
        void add(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = tail = newNode;
                return;
            }
            tail.next = newNode;
            tail = newNode;
        }

        // remove from head
        int remove() {
            if (isEmpty()) {
                System.out.println("empty queue");
                return Integer.MIN_VALUE;
            }
            int ans = head.data;
            if (tail == head) {
                tail = head = null;
            } else {
                head = head.next;
            }
            return ans;
        }

        int peek() {
            if (isEmpty()) {
                System.out.println("empty queue");
                return Integer.MIN_VALUE;
            }
            return head.data;
        }
    }

    public static void main(String[] args) {
        // Que of our own
        // Que q = new Que();
        // builtin Queue is an interface so we use LinkedList or ArrayDeque (as they
        // implements Queue)
        // Queue<Integer> q = new LinkedList<>();
        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        q.add(2);
        q.add(3);
        // for custom que
        // int d = q.head.data;// the outer class C_LLQueue can access all the
        // subclass's attributes and
        // methods even if it is private
        // System.out.println(d);
        while (!q.isEmpty()) {
            System.out.println(q.peek());// 1 2 3
            q.remove();
        }
    }
}
