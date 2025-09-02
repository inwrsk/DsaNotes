package J_LinkedList;

//Node and Linkedlist are directly imported without declaring
public class D_MergeSort {
    static Node mergeSort(Node head) {
        // base case
        if (head == null || head.next == null) {
            return head;
        }
        // finding mid
        Node mid = findMid(head);
        Node nextToMid = mid.next;
        mid.next = null;
        Node leftHead = mergeSort(head);
        Node rightHead = mergeSort(nextToMid);
        return merge(leftHead, rightHead);
    }

    // finding the mid
    static Node findMid(Node head) {
        Node sPtr = head;
        Node fPtr = head.next;
        while (fPtr != null && fPtr.next != null) {
            sPtr = sPtr.next;
            fPtr = fPtr.next.next;
        }
        return sPtr;
    }

    static Node merge(Node head, Node mid) {
        Node temp = new Node(-1);
        Node mainhead = temp;
        while (head != null && mid != null) {
            if (head.data > mid.data) {
                temp.next = mid;
                mid = mid.next;
                temp = temp.next;
            } else {
                temp.next = head;
                head = head.next;
                temp = temp.next;
            }
        }
        while (head != null) {
            temp.next = head;
            temp = temp.next;
            head = head.next;
        }
        while (mid != null) {
            temp.next = mid;
            temp = temp.next;
            mid = mid.next;
        }
        head = mainhead.next;
        return head;
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.addFirst(1);
        ll.addFirst(-2);
        ll.addFirst(600);
        ll.addFirst(3);
        ll.addFirst(-4);
        ll.printLList();
        ll.head = mergeSort(ll.head);
        ll.printLList();
    }
}
