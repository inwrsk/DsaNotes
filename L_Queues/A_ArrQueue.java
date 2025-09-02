package L_Queues;

// imagine queue as a water flow in  pipe
// imagine stack as bucket
// elements pushed at end and removed from index 0
// front is always at the begining
// rear starts from -1 as rear = front = 0 denotes one element
public class A_ArrQueue {
    static class Queue {
        static int[] arr;
        int size = 0;
        static int front = 0;
        static int rear = -1;

        Queue(int n) {
            arr = new int[n];
            size = n;
        }

        // if rear == -1 the queue is empty
        static boolean isEmpty() {
            return rear == -1;
        }

        // increase the rear to add
        void add(int data) {
            if (rear == arr.length - 1) {
                System.out.println("broo queue is already full!!");
                return;
            }
            rear += 1;
            arr[rear] = data;
        }

        // if an element removed then shift the remaining elements to the right O(n)
        int remove() {
            if (isEmpty()) {
                System.out.println("broo queue is empty!!");
                return Integer.MIN_VALUE;
            }
            int front = arr[0];
            for (int i = 0; i < rear; i++) {
                arr[i] = arr[i + 1];
            }
            rear -= 1;
            return front;
        }

        // return the first element
        int peek() {
            if (isEmpty()) {
                System.out.println("broo queue is empty!!");
                return Integer.MIN_VALUE;
            }
            return arr[0];
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue(5);
        q.add(1);
        q.add(2);
        q.add(3);
        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }
        System.out.println(q.remove());
    }
}
// 1 2 3

// broo queue
// is empty!!-
// 2147483648