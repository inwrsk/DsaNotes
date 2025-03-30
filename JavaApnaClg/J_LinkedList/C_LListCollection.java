package J_LinkedList;

import java.util.LinkedList;

public class C_LListCollection {
    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<>();
        // implementing linkedlist
        // add appends (adds at last)
        ll.add(1);
        ll.add(2);
        ll.addLast(3);// same
        ll.add(100);
        ll.addFirst(0);
        System.out.println(ll);// [0, 1, 2, 3, 100]
        ll.remove(4);// removes element at given index or throws error if indexoutofbound
        System.out.println(ll);// [0, 1, 2, 3]
        ll.remove();// removes head
        System.out.println(ll);// [1, 2, 3]
        ll.removeLast(); // removes tail
        System.out.println(ll);// [1, 2]
        System.out.println(ll.get(0));// 1
    }
}
