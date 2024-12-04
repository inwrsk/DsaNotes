package K_Stacks;

//head is the top of stack for linkedlist
public class StackLinkedList {
    Node head;

    // isEmpty
    boolean isEmpty() {
        return head == null;
    }

    // push
    void push(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    // pop
    int pop() {
        if (isEmpty()) {
            return Integer.MIN_VALUE;
        }
        int value = head.data;
        head = head.next;
        return value;
    }

    // peek
    int peek() {
        if (isEmpty()) {
            return -1;
        }
        return head.data;
    }

    public static void main(String[] args) {
        StackLinkedList s = new StackLinkedList();
        s.push(0);
        s.push(1);
        s.push(2);
        s.push(3);
        while (s.head != null) {
            System.out.println(s.peek());
            s.pop();
        }
    }
}
