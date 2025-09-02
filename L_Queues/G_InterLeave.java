package L_Queues;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

//if 1 2 3 4 5 6 is the given queue
//make it 1 4 2 5 3 6
public class G_InterLeave {
    static void interLeave(Queue<Integer> q) {
        Queue<Integer> q2 = new LinkedList<>();
        // export the first half to another queue
        int q2size = q.size() / 2;
        for (int i = 0; i < q2size; i++) {
            q2.add(q.remove());
        }
        // alternatively add the elements
        for (int i = 0; i < q2size; i++) {
            q.add(q2.remove());
            q.add(q.remove());
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
        interLeave(q);
        System.out.println(q);// [1, 5, 2, 6, 3, 7, 4, 8]
    }
}
