package J_LinkedList;

public class LinkedList {

    Node head;
    Node tail;
    int size;

    // finding middle node
    Node findMid() {
        Node slowPtr = head;
        Node fastPtr = head;
        while (fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        return slowPtr;
    }

    // changes the linked list (function is just for only idea)
    boolean checkPalindrome() {
        if (head == null || head.next == null) {
            return true;
        }
        // finding mid
        Node mid = findMid();
        // reverse second half
        Node tempHead = head;
        head = mid;
        reverse();// note this step will modify the linked list permenantly
        mid = head;
        head = tempHead;
        // compare this two linked lists
        // llist with original head will have one extra node
        // so iterate over the second linked list which has smallerlength
        Node left = head;
        Node right = mid;
        while (right != null) {
            if (right.data != left.data) {
                return false;
            }
            right = right.next;
            left = left.next;
        }
        return true;
    }

    // delete nth node from end
    // 1 2 3 4 5 (nodes)
    // 5 4 3 2 1 (nth node from end)
    int delNthFromEnd(int n) {
        // check if the index in invalid
        if (n < 1 || n > size) {
            System.out.println("index Error");
            return Integer.MIN_VALUE;
        }
        if (n == 1) {
            return removeLast();
        }
        if (n == size) {
            return removeFirst();
        }
        int ind = size - n;// index of node to be deleted form begining
        int prevInd = ind - 1;// index of previous node
        Node temp = head;
        // temp is pointing to head
        // we have to move temp to the previous of the node that should be deleted
        // if prevInd at 0 we are at correct position head
        // if prevINd at 1 we should move one step from head
        // similary we should move n steps from head
        while (prevInd != 0) {
            temp = temp.next;
            prevInd--;
        }
        int data = temp.next.data;
        temp.next = temp.next.next;
        return data;
    }

    // reverse linked list
    void reverse() {
        tail = head;
        Node prev = null;
        Node curr = head;
        Node next = curr.next;
        while (next != null) {
            curr.next = prev;
            prev = curr;
            curr = next;
            next = curr.next;
        }
        // now curr is the last element
        curr.next = prev;
        head = curr;
    }

    // remove first element
    int removeFirst() {
        // if linkedlist is empty
        if (head == null) {
            System.out.println("list hi nahi hai kya delete karna chahthe ho?");
            return Integer.MIN_VALUE;
        }
        // if there is only one element(we should update tail)
        size--;
        if (head == tail) {
            int data = head.data;
            head = tail = null;
            return data;
        }
        int data = head.data;
        head = head.next;// that node is cleared by garbage collector
        return data;
    }

    // remove last node
    int removeLast() {
        Node temp = head;
        if (temp == null || temp.next == null) {
            size = 0;
            head = tail = null;
            return Integer.MIN_VALUE;
        }
        // traversing to last but one node
        while (temp.next.next != null) {
            temp = temp.next;
        }
        size--;
        tail = temp;
        int data = temp.next.data;
        temp.next = null;
        return data;
    }

    // add at index i
    void add(int i, int data) {
        Node newNode = new Node(data);
        Node temp = head;
        Node pretemp = null;
        // i = 0 means the pretemp and temp are at correct positions
        // if not 0 then we move them forward using this loop below
        while (i > 0) {
            if (temp != null) {
                pretemp = temp;
                temp = temp.next;
                i--;
            } else {
                System.out.println("out of boundary!!!");
                return;
            }
        }
        // now the pretemp and temp are at correct positions
        if (pretemp == null) {// i.e insertion should be at first pos
            addFirst(data);
            return;
        }
        size++;
        pretemp.next = newNode;
        newNode.next = temp;
    }

    // add node at first position
    void addFirst(int data) {// O(1)
        size++;
        if (head == null) {
            head = tail = new Node(data);
        } else {
            Node temp = new Node(data);
            temp.next = head;
            head = temp;
        }
        return;
    }

    // add node at last position
    void addLast(int data) {// O(1)
        size++;
        Node temp = new Node(data);
        if (tail == null) {
            head = tail = temp;
            return;
        }
        tail.next = temp;
        tail = temp;

    }

    // search key in list (iterative method)
    int search(int key) {
        Node temp = head;
        int i = 0;
        while (temp != null) {
            if (key == temp.data) {
                return i;
            }
            temp = temp.next;
            i++;
        }
        return -1;
    }

    // recursive method
    int search(Node head, int key) {
        if (head == null) {
            return -1;
        }
        if (head.data == key) {
            return 0;
        }
        int ind = search(head.next, key);
        if (ind == -1) {
            return -1;
        }
        return 1 + ind;
    }

    // printLinkedList
    void printLList() {// O(n)
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        LinkedList ll1 = new LinkedList();
        System.out.println(ll1.size);// 0
        ll1.addLast(1);
        ll1.addLast(2);
        ll1.addLast(3);
        System.out.println(ll1.head.data);// 1
        System.out.println(ll1.tail.data);// 3
        ll1.add(3, 5);
        ll1.add(3, 4);
        ll1.addFirst(0);
        ll1.add(99, 9);// out of boundary!!!
        ll1.removeFirst();
        ll1.removeLast();
        ll1.printLList();// 1->2->3->4->null
        System.out.println("searching 3 : " + ll1.search(3));// searching 3 : 2
        System.out.println("searching 333 : " + ll1.search(ll1.head, 333));// searching 333 : -1
        ll1.delNthFromEnd(1);
        ll1.delNthFromEnd(2);
        System.out.println("size: " + ll1.size);// size: 3
        ll1.reverse();
        ll1.printLList();// 3->1->null
        ll1.addLast(4);
        ll1.removeFirst();
        ll1.printLList();// 1->4->null
        System.out.println(ll1.checkPalindrome());// false
        ll1.addLast(1);
        ll1.printLList();// 1->4->1->null
        System.out.println(ll1.checkPalindrome());// true
    }
}
