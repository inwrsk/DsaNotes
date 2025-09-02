package J_LinkedList;

public class DLinkedList {
    DNode head;
    DNode tail;
    int size;

    void addFirst(int data) {
        DNode newNode = new DNode(data);
        if (head == null) {
            head = tail = newNode;
            size++;
            return;
        }
        head.prev = newNode;
        newNode.next = head;
        head = newNode;
        size++;
    }

    int removeFirst() {
        if (head == null) {
            return Integer.MIN_VALUE;
        }
        int val = head.data;
        size--;
        if (head == tail) {
            head = null;
            tail = null;
            return val;
        }
        head = head.next;
        head.prev = null;
        return val;
    }

    void print() {
        DNode temp = head;
        while (temp != null) {
            if (temp.next == null) {
                System.out.println(temp.data);
                break;
            }
            System.out.print(temp.data + "<->");
            temp = temp.next;
        }
    }

    void reverse() {
        DNode curr = head;
        DNode prev = null;
        DNode next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            curr.prev = next;

            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public static void main(String[] args) {
        DLinkedList dll = new DLinkedList();
        dll.addFirst(0);
        dll.addFirst(1);
        dll.addFirst(2);
        dll.reverse();
        dll.print();
        System.out.println(dll.size);
        dll.removeFirst();
        dll.print();
        System.out.println(dll.size);
    }
}
