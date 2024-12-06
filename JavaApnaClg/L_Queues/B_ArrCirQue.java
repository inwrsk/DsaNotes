package L_Queues;

//in circular queue we shift front after removing, instead of all the elements
//so front won't be 0 all the time so we won't declare front as 0 this time
//while adding if there is space in front we add it front also
public class B_ArrCirQue {

    static class CirQue {
        static int arr[];
        static int rear;
        static int front;
        static int size;

        CirQue(int n) {
            arr = new int[n];
            front = -1;
            rear = -1;
            size = n;
        }

        static boolean isEmpty() {
            return front == -1 && rear == -1;
        }

        // it is full when front is before rear (all the elements filled till the index
        // just before front
        static boolean isFull() {
            return (rear + 1) % size == front;
        }

        void add(int n) {
            // we can add elements till the tail filled till just before front
            if (isFull()) {
                return;
            }
            // if it is empty then initialize the rear and front
            if (isEmpty()) {
                rear = front = 0;
                arr[0] = n;
                return;
            }
            rear = (rear + 1) % size;
            arr[rear] = n;
            return;
        }

        int remove() {
            if (isEmpty()) {
                return Integer.MIN_VALUE;
            }
            int res = arr[front];
            // if front == rear then only one element is present
            // after removing it reinititalize the queue from -1th position
            if (front == rear) {
                front = rear = -1;
            } else {
                front = (front + 1) % size;
            }
            return res;
        }

        int peek() {
            if (isEmpty()) {
                return Integer.MIN_VALUE;
            }
            return arr[front];
        }

    }

    public static void main(String[] args) {
        CirQue cq = new CirQue(3);
        cq.add(1);
        cq.add(2);
        cq.add(3);
        System.out.println("cq.remove() " + cq.remove());// cq.remove()1
        System.out.println("cq.remove() " + cq.remove());// cq.remove()2
        cq.add(4);
        cq.add(5);
        while (!cq.isEmpty()) {
            System.out.println(cq.peek());// 3 4 5
            cq.remove();
        }
    }
}