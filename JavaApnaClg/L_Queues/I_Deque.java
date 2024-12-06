package L_Queues;

import java.util.Deque;
import java.util.LinkedList;
import java.util.ArrayDeque;

//Double Ended Queue
public class I_Deque {
    public static void main(String[] args) {
        // Deque<Integer> dq = new LinkedList<>();
        // or
        Deque<Integer> dq = new ArrayDeque<>();
        // add => adds at begining
        dq.add(1);
        dq.addFirst(2);
        dq.addLast(3);
        System.out.println(dq);// [2, 1, 3]
        System.out.println(dq.getLast());// 3
        System.out.println(dq.getFirst());// 2
        // removes at first
        System.out.println(dq.remove());// 2
        System.out.println(dq.removeLast());// 3
        System.out.println(dq.removeFirst());// 1

    }
}
