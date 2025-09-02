package J_LinkedList;

public class B_LinkedList {

    static class LinkedList {
        class Node {
            int data;
            Node next;

            Node(int data) {
                this.data = data;
                this.next = null;
            }
        }

        Node head;
        Node tail;
        int size;

        void addLast(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = tail = newNode;
                return;
            }
            tail.next = newNode;
            tail = newNode;
        }

        void printList() {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data + "->");
                temp = temp.next;
            }
            System.out.println("null");
        }

        // finding if there is a cycle in linked list
        // so if we take slowpointer and fast pointer
        // they won't meet if the list is straight
        // if the loop has a cycle
        // they will enter the loop
        // as relative velocity of fp compared to sp is 1
        // fp will definetly meet sp at some point
        // so we can say that has a loop if fp and sp are same at some point
        // but mean while if we encounter null so it will has no loop
        boolean isCycle() {
            Node fastPtr = head;
            Node slowPtr = head;
            // the null pointer is found first by fast pointer
            while (fastPtr != null && fastPtr.next != null) {
                fastPtr = fastPtr.next.next;
                slowPtr = slowPtr.next;
                if (fastPtr == slowPtr) {
                    return true;
                }
            }
            // if we encounter null then no loop return false
            return false;
        }

        // NOte : only use this if there is a cycle
        // if not you get null pointer exception as we iterate over the list till we
        // find the junction point
        void removeCycle() {
            System.out.println("printing the linked list with cycle");
            System.out.print(head.data + "->");
            Node sp = head.next;
            Node fp = head.next.next;
            Node beforefp = head.next;// beforefp always before fp
            // loop breaks when we found the juction
            // there also before fp is just before fp
            while (fp != sp) {
                System.out.print(sp.data + "->");
                beforefp = fp.next;
                fp = fp.next.next;
                sp = sp.next;
            }
            // so after finding loop we initialize sp to head
            sp = head;
            // they meet at the junction and beforefp is at the tail position
            while (sp != fp) {
                System.out.print(fp.data + "->");
                beforefp = fp;
                fp = fp.next;
                sp = sp.next;
            }
            System.out.println(fp.data);
            // removing the tail connectivity
            beforefp.next = null;
        }

    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.printList();// 1->2->3->4->null
        System.out.println(ll.isCycle());// false
        ll.tail.next = ll.head;
        System.out.println(ll.isCycle());// true;
        ll.removeCycle();
        // printing the linked list with cycle
        // 1->2->3->4->1
        System.out.println(ll.isCycle());// false
        ll.printList();// 1->2->3->4->null
    }
}
